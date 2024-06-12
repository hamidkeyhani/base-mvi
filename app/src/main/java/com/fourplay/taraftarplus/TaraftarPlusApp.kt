package com.fourplay.taraftarplus

import android.app.Application
import android.util.Log
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import dagger.hilt.android.HiltAndroidApp
import ly.count.android.sdk.Countly
import ly.count.android.sdk.CountlyConfig
import timber.log.Timber

@HiltAndroidApp
class TaraftarPlusApp : Application(), ImageLoaderFactory {

//    @Inject
//    lateinit var appContext: Context

    override fun onCreate() {
        super.onCreate()
        // Initialize Sync; the system responsible for keeping data in the app up to date.
//        Sync.initialize(context = this)

        val appConfig = CountlyConfig(
            this,
            "5d67ca40be7b520caa51a7bf36dbf9e75f62860f",
            "https://trial-adivery.count.ly"
        )
            .setLoggingEnabled(true)
//            .setParameterTamperingProtectionSalt("153546849785")

        Countly.sharedInstance().init(appConfig)

        Countly.sharedInstance().events().recordEvent("madsein", 1)

//        Countly.sharedInstance().setViewTracking(true)
//        Countly.sharedInstance().flushRequestQueues()
//        Countly.sharedInstance().doStoredRequests()

        Log.i(
            "TAG",
            "onCreate1: Countly sdk initialized: ${Countly.sharedInstance().isInitialized}"
        )

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Since we're displaying SVGs in the app, Coil needs an ImageLoader which supports this
     * format. During Coil's initialization it will call `applicationContext.newImageLoader()` to
     * obtain an ImageLoader.
     *
     * @see <a href="https://github.com/coil-kt/coil/blob/main/coil-singleton/src/main/java/coil/Coil.kt">Coil</a>
     */
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }

}