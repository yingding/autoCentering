# About this project

This repository demonstrates the different setting for `ScalingLazyListState` and `autoCentering` params of `ScalingLazyColumn` of the Wear
of the wear-compose lib `androidx.wear.compose:compose-material:1.0.0`

```kotlin
   /* working and show full screen image directly */
   val stateParams = Pair(0, 0)
   val autoCenteringParams = Pair(0, 0)

   /* working and show full screen image with 40 px offset directly */
   val stateParams = Pair(0, 40)
   val autoCenteringParams = Pair(0, 40)

   /* not working and show black screen, at first, with scrolling the image appears */
   val stateParams = Pair(1, 0)
   val autoCenteringParams = Pair(1, 0)
   /* not working, conflict of settings */
   val stateParams = Pair(1, 0)
   val autoCenteringParams = Pair(2, 0)
```

# Different Behaviours

With the params
```kotlin
      val stateParams = Pair(0, 0)
      val autoCenteringParams = Pair(0, 0)
```
The demo app works as expected, will show a full screen image and a text right at app start.
https://github.com/yingding/autoCentering/blob/main/video/showImageAtStart.mov

With the params
```kotlin
   val stateParams = Pair(1, 0)
   val autoCenteringParams = Pair(1, 0)
```
or
```kotlin
   val stateParams = Pair(1, 0)
   val autoCenteringParams = Pair(2, 0)
```
The demo app doesn't work as exprected, will show a black screen at app start.
After the manually interaction through scrolling, the full screen image is then shown.
https://github.com/yingding/autoCentering/blob/main/video/NotShowingImageAtStart.mov






