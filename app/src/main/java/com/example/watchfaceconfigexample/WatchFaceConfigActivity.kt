package com.example.watchfaceconfigexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListAnchorType
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import com.example.watchfaceconfigexample.R
import com.example.watchfaceconfigexample.theme.WearAppTheme


class WatchFaceConfigActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* working and show full screen image directly */
//            val stateParams = Pair(0, 0)
//            val autoCenteringParams = Pair(0, 0)
            /* working and show full screen image with 40 px offset directly */
//            val stateParams = Pair(0, 40)
//            val autoCenteringParams = Pair(0, 40)
            /* not working and show black screen, at first, with scrolling the image appears */
            val stateParams = Pair(1, 0)
            val autoCenteringParams = Pair(1, 0)
            /* not working, conflict of settings */
//            val stateParams = Pair(1, 0)
//            val autoCenteringParams = Pair(2, 0)
            WatchfaceConfigApp(stateParams, autoCenteringParams)
        }
    }
}

@Composable
fun WatchfaceConfigApp(
    stateParams: Pair<Int, Int>,
    autoCenteringParams: Pair<Int, Int>
) {
    WearAppTheme {
        val state: ScalingLazyListState = rememberScalingLazyListState(stateParams.first, stateParams.second)
        Scaffold (
            vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
            positionIndicator = { PositionIndicator(scalingLazyListState = state) }
        ) {
            ScalingLazyColumn (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                state = state,
                anchorType = ScalingLazyListAnchorType.ItemCenter,
                autoCentering = AutoCenteringParams(autoCenteringParams.first, autoCenteringParams.second)
                // the autoCentering param must be the same as the sate param, since we have full screen element, default 1, 0 will not work.
            ) {
                item {
                    FullScreenImage()
                }

                item {
                    FullScreenText()
                }
            }
        }
    }
}

@Composable
fun FullScreenImage() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter= painterResource(R.drawable.watch_preview_circular_384),
            contentDescription = "Yellow fullscreen"
        )
    }
}

@Composable
fun FullScreenText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hello World!")
    }
}