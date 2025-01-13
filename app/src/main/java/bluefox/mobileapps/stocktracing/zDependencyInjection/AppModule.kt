package bluefox.mobileapps.stocktracing.zDependencyInjection

import bluefox.mobileapps.stocktracing.zAPIEndPoints.ApiHelper
import bluefox.mobileapps.stocktracing.zAPIEndPoints.ApiHelperImplementation
import bluefox.mobileapps.stocktracing.zAPIEndPoints.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = "https://dummyjson.com/"


    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.cache(null)

        if (true) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(loggingInterceptor)
        }

        builder.addNetworkInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Cache-Control", "no-cache")
                .header("Pragma", "no-cache")
                .build()
            chain.proceed(request)
        }

        return builder.build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

    @Provides
    fun provideApiHelper(apiHelper: ApiHelperImplementation): ApiHelper = apiHelper
}