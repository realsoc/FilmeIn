package com.example.filmein.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

val EyeOpen: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 384.dp,
            defaultHeight = 384.dp,
            viewportWidth = 384f,
            viewportHeight = 384f
        ).apply {
            group {
                group {
                    path(
                        fill = SolidColor(Color(0xFFFFFFFF)),
                        fillAlpha = 0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(384f, 384f)
                        horizontalLineTo(0f)
                        verticalLineTo(0f)
                        horizontalLineTo(384f)
                        close()
                        moveTo(344.87f, 239.67f)
                        curveToRelative(-1.69f, 1.61f, -2.69f, 2.54f, -3.68f, 3.49f)
                        arcToRelative(538f, 538f, 0f, isMoreThanHalf = false, isPositiveArc = true, -61f, 50.88f)
                        curveToRelative(-7.24f, 5.13f, -8.83f, 14f, -4f, 20.72f)
                        reflectiveCurveToRelative(13.53f, 8f, 20.59f, 3f)
                        arcToRelative(543.46f, 543.46f, 0f, isMoreThanHalf = false, isPositiveArc = false, 77.9f, -67.31f)
                        arcToRelative(17.31f, 17.31f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.84f, -6.29f)
                        curveToRelative(1.95f, -5.79f, 0f, -10.75f, -4.11f, -15f)
                        arcToRelative(554f, 554f, 0f, isMoreThanHalf = false, isPositiveArc = false, -74.65f, -64.8f)
                        curveToRelative(-20.66f, -14.8f, -42.33f, -27.8f, -66.34f, -36.53f)
                        curveToRelative(-20.84f, -7.57f, -42.09f, -10.36f, -64f, -5.5f)
                        curveToRelative(-18.3f, 4.06f, -35.33f, 11.38f, -51.58f, 20.54f)
                        curveTo(77.37f, 165.65f, 42.46f, 195.61f, 10f, 228.61f)
                        curveToRelative(-7.32f, 7.44f, -7.33f, 15.24f, -0.07f, 22.67f)
                        curveToRelative(26f, 26.64f, 53.92f, 51f, 84.9f, 71.74f)
                        curveToRelative(20.92f, 14f, 42.9f, 25.86f, 67.31f, 32.82f)
                        curveToRelative(25f, 7.14f, 49.38f, 4.7f, 73.34f, -4.46f)
                        arcToRelative(14.24f, 14.24f, 0f, isMoreThanHalf = false, isPositiveArc = false, 9.29f, -14.76f)
                        curveToRelative(-0.74f, -6.76f, -5.28f, -12.12f, -12f, -12.95f)
                        curveToRelative(-3.17f, -0.39f, -6.7f, 0.45f, -9.8f, 1.5f)
                        curveToRelative(-13.4f, 4.55f, -27f, 7.21f, -41.18f, 5.13f)
                        curveToRelative(-17.93f, -2.63f, -34.19f, -9.83f, -49.84f, -18.54f)
                        curveToRelative(-30f, -16.71f, -56.41f, -38.19f, -81.53f, -61.4f)
                        curveToRelative(-3.64f, -3.36f, -7.19f, -6.82f, -11.22f, -10.65f)
                        curveToRelative(10.79f, -9.63f, 21f, -19.15f, 31.68f, -28.21f)
                        curveToRelative(23f, -19.56f, 47.24f, -37.29f, 74.66f, -50.26f)
                        curveToRelative(12.91f, -6.11f, 26.26f, -10.89f, 40.63f, -12.09f)
                        curveToRelative(17.6f, -1.47f, 33.83f, 3.72f, 49.54f, 10.82f)
                        curveToRelative(26.73f, 12.09f, 50.4f, 29f, 72.79f, 47.68f)
                        curveTo(320.74f, 217.89f, 332.48f, 228.74f, 344.87f, 239.67f)
                        close()
                        moveTo(264f, 240f)
                        arcTo(72f, 72f, 0f, isMoreThanHalf = true, isPositiveArc = false, 191.89f, 312f)
                        arcTo(71.78f, 71.78f, 0f, isMoreThanHalf = false, isPositiveArc = false, 264f, 240f)
                        close()
                        moveTo(206.32f, 67.4f)
                        horizontalLineToRelative(0.06f)
                        curveToRelative(0f, -9.12f, 0.05f, -18.25f, 0f, -27.38f)
                        arcToRelative(22.25f, 22.25f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.73f, -6.27f)
                        curveTo(203.5f, 27f, 197f, 23.08f, 189.83f, 24f)
                        arcToRelative(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = false, -12.17f, 13.58f)
                        curveToRelative(-0.17f, 19.76f, -0.07f, 39.51f, 0f, 59.26f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.64f, 3.66f)
                        curveToRelative(2.31f, 6.93f, 8.7f, 10.72f, 16.19f, 9.69f)
                        arcToRelative(13.89f, 13.89f, 0f, isMoreThanHalf = false, isPositiveArc = false, 11.81f, -13.48f)
                        curveTo(206.47f, 86.91f, 206.32f, 77.16f, 206.32f, 67.4f)
                        close()
                        moveTo(28.72f, 71.87f)
                        curveToRelative(-6f, 0.17f, -10.5f, 2.93f, -13.08f, 8.38f)
                        curveToRelative(-2.75f, 5.82f, -1.82f, 11.43f, 2.58f, 15.93f)
                        quadToRelative(19.28f, 19.69f, 39f, 39f)
                        arcTo(14.1f, 14.1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 77.4f, 135f)
                        arcToRelative(14.29f, 14.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.11f, -20.52f)
                        curveTo(64.64f, 101.64f, 51.87f, 89f, 39.14f, 76.25f)
                        arcTo(13.92f, 13.92f, 0f, isMoreThanHalf = false, isPositiveArc = false, 28.72f, 71.87f)
                        close()
                        moveTo(369.9f, 88.11f)
                        curveToRelative(-0.56f, -8f, -3.34f, -12.69f, -9.06f, -15.07f)
                        curveToRelative(-6f, -2.51f, -11.53f, -1.29f, -16.15f, 3.32f)
                        quadToRelative(-19f, 18.92f, -37.89f, 37.91f)
                        curveToRelative(-6f, 6f, -6.05f, 14.66f, -0.43f, 20.51f)
                        reflectiveCurveToRelative(14.59f, 6.12f, 20.78f, 0f)
                        curveToRelative(12.83f, -12.61f, 25.6f, -25.3f, 38.08f, -38.25f)
                        curveTo(367.74f, 94f, 368.87f, 90f, 369.9f, 88.11f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(344.87f, 239.67f)
                        curveToRelative(-12.39f, -10.93f, -24.13f, -21.78f, -36.39f, -32f)
                        curveToRelative(-22.39f, -18.71f, -46.06f, -35.59f, -72.79f, -47.68f)
                        curveToRelative(-15.71f, -7.1f, -31.94f, -12.29f, -49.54f, -10.82f)
                        curveToRelative(-14.37f, 1.2f, -27.72f, 6f, -40.63f, 12.09f)
                        curveToRelative(-27.42f, 13f, -51.68f, 30.7f, -74.66f, 50.26f)
                        curveTo(60.22f, 220.56f, 50f, 230.08f, 39.18f, 239.71f)
                        curveToRelative(4f, 3.83f, 7.58f, 7.29f, 11.22f, 10.65f)
                        curveToRelative(25.12f, 23.21f, 51.54f, 44.69f, 81.53f, 61.4f)
                        curveToRelative(15.65f, 8.71f, 31.91f, 15.91f, 49.84f, 18.54f)
                        curveToRelative(14.2f, 2.08f, 27.78f, -0.58f, 41.18f, -5.13f)
                        curveToRelative(3.1f, -1.05f, 6.63f, -1.89f, 9.8f, -1.5f)
                        curveToRelative(6.74f, 0.83f, 11.28f, 6.19f, 12f, 12.95f)
                        arcToRelative(14.24f, 14.24f, 0f, isMoreThanHalf = false, isPositiveArc = true, -9.29f, 14.76f)
                        curveToRelative(-24f, 9.16f, -48.31f, 11.6f, -73.34f, 4.46f)
                        curveToRelative(-24.41f, -7f, -46.39f, -18.82f, -67.31f, -32.82f)
                        curveToRelative(-31f, -20.73f, -58.91f, -45.1f, -84.9f, -71.74f)
                        curveToRelative(-7.26f, -7.43f, -7.25f, -15.23f, 0.07f, -22.67f)
                        curveToRelative(32.46f, -33f, 67.37f, -63f, 107.91f, -85.78f)
                        curveToRelative(16.25f, -9.16f, 33.28f, -16.48f, 51.58f, -20.54f)
                        curveToRelative(21.89f, -4.86f, 43.14f, -2.07f, 64f, 5.5f)
                        curveToRelative(24f, 8.73f, 45.68f, 21.73f, 66.34f, 36.53f)
                        arcToRelative(554f, 554f, 0f, isMoreThanHalf = false, isPositiveArc = true, 74.65f, 64.8f)
                        curveToRelative(4.15f, 4.27f, 6.06f, 9.23f, 4.11f, 15f)
                        arcToRelative(17.31f, 17.31f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.84f, 6.29f)
                        arcToRelative(543.46f, 543.46f, 0f, isMoreThanHalf = false, isPositiveArc = true, -77.9f, 67.31f)
                        curveToRelative(-7.06f, 5f, -15.78f, 3.63f, -20.59f, -3f)
                        reflectiveCurveToRelative(-3.25f, -15.59f, 4f, -20.72f)
                        arcToRelative(538f, 538f, 0f, isMoreThanHalf = false, isPositiveArc = false, 61f, -50.88f)
                        curveTo(342.18f, 242.21f, 343.18f, 241.28f, 344.87f, 239.67f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(264f, 240f)
                        arcToRelative(72f, 72f, 0f, isMoreThanHalf = true, isPositiveArc = true, -71.75f, -72f)
                        arcTo(71.8f, 71.8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 264f, 240f)
                        close()
                        moveTo(192f, 197f)
                        arcTo(43f, 43f, 0f, isMoreThanHalf = true, isPositiveArc = false, 235f, 240.13f)
                        arcTo(42.77f, 42.77f, 0f, isMoreThanHalf = false, isPositiveArc = false, 192f, 197f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(206.32f, 67.4f)
                        curveToRelative(0f, 9.76f, 0.15f, 19.51f, 0f, 29.26f)
                        arcToRelative(13.89f, 13.89f, 0f, isMoreThanHalf = false, isPositiveArc = true, -11.81f, 13.48f)
                        curveToRelative(-7.49f, 1f, -13.88f, -2.76f, -16.19f, -9.69f)
                        arcToRelative(12f, 12f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.64f, -3.66f)
                        curveToRelative(0f, -19.75f, -0.14f, -39.5f, 0f, -59.26f)
                        arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 189.83f, 24f)
                        curveToRelative(7.21f, -0.87f, 13.67f, 3f, 15.79f, 9.8f)
                        arcToRelative(22.25f, 22.25f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.73f, 6.27f)
                        curveToRelative(0.08f, 9.13f, 0f, 18.26f, 0f, 27.38f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(28.72f, 71.87f)
                        arcToRelative(13.92f, 13.92f, 0f, isMoreThanHalf = false, isPositiveArc = true, 10.42f, 4.38f)
                        curveTo(51.87f, 89f, 64.64f, 101.64f, 77.29f, 114.44f)
                        arcTo(14.29f, 14.29f, 0f, isMoreThanHalf = false, isPositiveArc = true, 77.4f, 135f)
                        arcToRelative(14.1f, 14.1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -20.21f, 0.18f)
                        quadToRelative(-19.71f, -19.26f, -39f, -39f)
                        curveToRelative(-4.4f, -4.5f, -5.33f, -10.11f, -2.58f, -15.93f)
                        curveTo(18.22f, 74.8f, 22.69f, 72f, 28.72f, 71.87f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(369.9f, 88.11f)
                        curveToRelative(-1f, 1.93f, -2.16f, 5.86f, -4.67f, 8.46f)
                        curveToRelative(-12.48f, 13f, -25.25f, 25.64f, -38.08f, 38.25f)
                        curveToRelative(-6.19f, 6.08f, -15.09f, 5.88f, -20.78f, 0f)
                        reflectiveCurveToRelative(-5.53f, -14.49f, 0.43f, -20.51f)
                        quadToRelative(18.85f, -19f, 37.89f, -37.91f)
                        curveToRelative(4.62f, -4.61f, 10.15f, -5.83f, 16.15f, -3.32f)
                        curveTo(366.56f, 75.42f, 369.34f, 80.1f, 369.9f, 88.11f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFFFFF)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(192f, 197f)
                        arcTo(43f, 43f, 0f, isMoreThanHalf = true, isPositiveArc = true, 149f, 240f)
                        arcTo(42.8f, 42.8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 192f, 197f)
                        close()
                    }
                }
            }
        }.build()
        return _vector!!
    }

