import com.fourplay.network.model.CommonResponse
import com.fourplay.network.model.refreshToken.RefreshTokenRequestDto
import com.fourplay.network.model.refreshToken.RefreshTokenResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshApi{

    @POST("api/core/v1/authentication/refresh-token")
    suspend fun refreshToken(
        @Body request: RefreshTokenRequestDto
    ): Response<CommonResponse<RefreshTokenResponseDto>>

}