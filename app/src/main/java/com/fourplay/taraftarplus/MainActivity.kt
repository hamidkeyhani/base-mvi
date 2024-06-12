package com.fourplay.taraftarplus

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.fourplay.designsystem.theme.TaraftarPlusTheme
import com.fourplay.taraftarplus.ui.TaraftarApp
import com.fourplay.taraftarplus.ui.rememberTaraftarPlusAppState
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.count.android.sdk.Countly
import ly.count.android.sdk.CountlyConfig

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(
        ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class,
        ExperimentalMaterialApi::class, ExperimentalMaterialNavigationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

//        val appConfig = CountlyConfig(
//            this,
//            "5d67ca40be7b520caa51a7bf36dbf9e75f62860f",
//            "https://trial-adivery.count.ly/dashboard#/6660346df1298193326609fc/"
//        )
//            .setLoggingEnabled(true)
//            .setParameterTamperingProtectionSalt("153546849785")
//
//        Countly.sharedInstance().init(appConfig)
//
//        Countly.sharedInstance().events().recordEvent("madsein", 1)
//
////        Countly.sharedInstance().setViewTracking(true)
////        Countly.sharedInstance().flushRequestQueues()
////        Countly.sharedInstance().doStoredRequests()
//
//        Log.i(
//            "TAG",
//            "onCreate1: Countly sdk initialized: ${Countly.sharedInstance().isInitialized}"
//        )

        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        val viewModel: MainActivityViewModel by viewModels()

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        uiState = it
                    }
                    .collect()
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when (uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false
            }
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {

            // Remember a SystemUiController
            val systemUiController = rememberSystemUiController()

            DisposableEffect(systemUiController) {
                // Update all of the system bar colors to be transparent, and use
                // dark icons if we're in light theme
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = false
                )

                // setStatusBarColor() and setNavigationBarColor() also exist

                onDispose {}
            }

            val sheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                skipHalfExpanded = true
            )
            val bottomSheetNavigator = BottomSheetNavigator(sheetState)
            val navController = rememberNavController(bottomSheetNavigator)

            TaraftarPlusTheme(androidTheme = true) {
                ModalBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    sheetBackgroundColor = MaterialTheme.colorScheme.background
                ) {
                    TaraftarApp(
                        rememberTaraftarPlusAppState(
                            windowSizeClass = calculateWindowSizeClass(this),
                            navController = navController
                        )
                    )
                }
            }
        }

    }

}