package com.airbnb.lottie.compose

import android.net.Uri

/**
 * Specification for a [com.airbnb.lottie.LottieComposition]. Each subclass represents a different source.
 * A [com.airbnb.lottie.LottieComposition] is the stateless parsed version of a Lottie json file and is
 * passed into [rememberLottieComposition] or [LottieAnimation].
 */
sealed interface LottieCompositionSpec {

    /**
     * Load an animation from res/raw.
     */
    @JvmInline
    value class RawRes(@androidx.annotation.RawRes val resId: Int) : LottieCompositionSpec

    /**
     * Load an animation from the internet. Lottie has a default network stack that will use
     * standard Android networking APIs to attempt to load your animation. You may want to
     * integrate your own networking stack instead for consistency, to add your own headers,
     * or implement retries. To do that, call [com.airbnb.lottie.Lottie.initialize] and set
     * a [com.airbnb.lottie.network.LottieNetworkFetcher] on the [com.airbnb.lottie.LottieConfig].
     *
     * If you are using this spec, you may want to use [rememberLottieComposition] instead of
     * passing this spec directly into [LottieAnimation] because it can fail and you want to
     * make sure that you properly handle the failures and/or retries.
     */
    @JvmInline
    value class Url(val url: String) : LottieCompositionSpec

    /**
     * Load an animation from an arbitrary file. Make sure that your app has permissions to read it
     * or else this may fail.
     */
    @JvmInline
    value class File(val fileName: String) : LottieCompositionSpec

    /**
     * Load an animation from the assets directory of your app. This isn't type safe like [RawRes]
     * so make sure that the path to your animation is correct this will fail.
     */
    @JvmInline
    value class Asset(val assetName: String) : LottieCompositionSpec

    /**
     * Load an animation from its json string.
     */
    @JvmInline
    value class JsonString(val jsonString: String) : LottieCompositionSpec

    /**
     * Load an animation from a content provider URI.
     */
    @JvmInline
    value class ContentProvider(val uri: Uri) : LottieCompositionSpec
}
