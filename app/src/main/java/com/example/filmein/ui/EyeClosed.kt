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

val EyeClosed: ImageVector
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
                        moveTo(300.37f, 174.72f)
                        lineToRelative(6.13f, -3.78f)
                        arcToRelative(352.65f, 352.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, 67.79f, -53.84f)
                        curveToRelative(3.61f, -3.67f, 5.7f, -7.9f, 4.83f, -13.13f)
                        curveToRelative(-1f, -5.77f, -4.28f, -9.85f, -9.85f, -11.62f)
                        curveToRelative(-6f, -1.93f, -11.16f, -0.08f, -15.6f, 4.41f)
                        curveToRelative(-26.53f, 26.84f, -56.46f, 49f, -90.92f, 64.63f)
                        curveToRelative(-18.59f, 8.45f, -38f, 14.21f, -58.41f, 15.93f)
                        curveToRelative(-24.27f, 2.05f, -47.59f, -2.32f, -70.25f, -10.9f)
                        arcTo(253.86f, 253.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, 86.35f, 141.9f)
                        curveToRelative(-4.25f, -2.74f, -8.69f, -3.78f, -13.5f, -2.23f)
                        arcTo(13.73f, 13.73f, 0f, isMoreThanHalf = false, isPositiveArc = false, 63f, 151.32f)
                        curveToRelative(-0.89f, 6f, 1.49f, 10.8f, 6.48f, 14.14f)
                        curveToRelative(4.71f, 3.15f, 9.58f, 6.06f, 15f, 9.48f)
                        curveToRelative(-1.49f, 1.21f, -2.65f, 2f, -3.62f, 2.94f)
                        curveTo(67f, 191.72f, 53.23f, 205.61f, 39.33f, 219.41f)
                        curveTo(34.85f, 223.85f, 33f, 229f, 34.89f, 235f)
                        curveToRelative(3.31f, 10.65f, 16.22f, 13.48f, 24.4f, 5.35f)
                        curveTo(75.58f, 224.2f, 91.86f, 208f, 107.93f, 191.61f)
                        curveToRelative(2.68f, -2.74f, 4.67f, -2.86f, 7.94f, -1.43f)
                        arcToRelative(208f, 208f, 0f, isMoreThanHalf = false, isPositiveArc = false, 55.92f, 15.44f)
                        curveToRelative(6.16f, 0.82f, 6.15f, 0.83f, 6.15f, 7.26f)
                        curveToRelative(0f, 22.08f, -0.06f, 44.17f, 0.1f, 66.26f)
                        curveToRelative(0.06f, 7.41f, 5.35f, 12.81f, 12.73f, 13.77f)
                        arcToRelative(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = false, 15.24f, -10f)
                        arcToRelative(24.83f, 24.83f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.69f, -7f)
                        quadToRelative(0.08f, -33.13f, 0f, -66.26f)
                        curveToRelative(0f, -1.95f, -0.17f, -3.63f, 2.65f, -3.88f)
                        curveToRelative(21f, -1.85f, 41f, -7.7f, 60.34f, -15.95f)
                        curveToRelative(3f, -1.27f, 4.54f, -0.68f, 6.63f, 1.42f)
                        quadToRelative(24.36f, 24.6f, 48.92f, 49f)
                        curveToRelative(5.71f, 5.69f, 13.31f, 6.44f, 19.34f, 2.08f)
                        curveToRelative(7.34f, -5.31f, 7.93f, -15.59f, 1.09f, -22.53f)
                        curveToRelative(-10.95f, -11.11f, -22f, -22.09f, -33.06f, -33.11f)
                        curveTo(308.67f, 182.76f, 304.64f, 178.89f, 300.37f, 174.72f)
                        close()
                        moveTo(29f, 131f)
                        curveToRelative(6.16f, -0.82f, 11.39f, -4.22f, 13.7f, -9.54f)
                        curveToRelative(2.51f, -5.76f, 1.46f, -11f, -2.62f, -15.59f)
                        curveToRelative(-3.07f, -3.43f, -6.46f, -6.58f, -9.77f, -9.79f)
                        curveToRelative(-6f, -5.82f, -14.73f, -6f, -20.47f, -0.36f)
                        reflectiveCurveToRelative(-6f, 14.29f, -0.28f, 20.44f)
                        arcToRelative(94.16f, 94.16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 10.14f, 9.94f)
                        curveTo(22.36f, 128.22f, 25.83f, 129.38f, 29f, 131f)
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
                        moveTo(300.37f, 174.72f)
                        curveToRelative(4.27f, 4.17f, 8.3f, 8f, 12.26f, 12f)
                        curveToRelative(11f, 11f, 22.11f, 22f, 33.06f, 33.11f)
                        curveToRelative(6.84f, 6.94f, 6.25f, 17.22f, -1.09f, 22.53f)
                        curveToRelative(-6f, 4.36f, -13.63f, 3.61f, -19.34f, -2.08f)
                        quadToRelative(-24.52f, -24.45f, -48.92f, -49f)
                        curveToRelative(-2.09f, -2.1f, -3.64f, -2.69f, -6.63f, -1.42f)
                        curveToRelative(-19.32f, 8.25f, -39.32f, 14.1f, -60.34f, 15.95f)
                        curveToRelative(-2.82f, 0.25f, -2.65f, 1.93f, -2.65f, 3.88f)
                        quadToRelative(0f, 33.12f, 0f, 66.26f)
                        arcToRelative(24.83f, 24.83f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.69f, 7f)
                        arcToRelative(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, -15.24f, 10f)
                        curveToRelative(-7.38f, -1f, -12.67f, -6.36f, -12.73f, -13.77f)
                        curveToRelative(-0.16f, -22.09f, -0.08f, -44.18f, -0.1f, -66.26f)
                        curveToRelative(0f, -6.43f, 0f, -6.44f, -6.15f, -7.26f)
                        arcToRelative(208f, 208f, 0f, isMoreThanHalf = false, isPositiveArc = true, -55.92f, -15.44f)
                        curveToRelative(-3.27f, -1.43f, -5.26f, -1.31f, -7.94f, 1.43f)
                        curveTo(91.86f, 208f, 75.58f, 224.2f, 59.29f, 240.38f)
                        curveToRelative(-8.18f, 8.13f, -21.09f, 5.3f, -24.4f, -5.35f)
                        curveToRelative(-1.88f, -6f, 0f, -11.18f, 4.44f, -15.62f)
                        curveToRelative(13.9f, -13.8f, 27.71f, -27.69f, 41.58f, -41.53f)
                        curveToRelative(1f, -1f, 2.13f, -1.73f, 3.62f, -2.94f)
                        curveToRelative(-5.44f, -3.42f, -10.31f, -6.33f, -15f, -9.48f)
                        curveToRelative(-5f, -3.34f, -7.37f, -8.19f, -6.48f, -14.14f)
                        arcToRelative(13.73f, 13.73f, 0f, isMoreThanHalf = false, isPositiveArc = true, 9.82f, -11.65f)
                        curveToRelative(4.81f, -1.55f, 9.25f, -0.51f, 13.5f, 2.23f)
                        arcToRelative(253.86f, 253.86f, 0f, isMoreThanHalf = false, isPositiveArc = false, 47.74f, 24.52f)
                        curveToRelative(22.66f, 8.58f, 46f, 13f, 70.25f, 10.9f)
                        curveToRelative(20.43f, -1.72f, 39.82f, -7.48f, 58.41f, -15.93f)
                        curveToRelative(34.46f, -15.68f, 64.39f, -37.79f, 90.92f, -64.63f)
                        curveToRelative(4.44f, -4.49f, 9.57f, -6.34f, 15.6f, -4.41f)
                        curveToRelative(5.57f, 1.77f, 8.89f, 5.85f, 9.85f, 11.62f)
                        curveToRelative(0.87f, 5.23f, -1.22f, 9.46f, -4.83f, 13.13f)
                        arcToRelative(352.65f, 352.65f, 0f, isMoreThanHalf = false, isPositiveArc = true, -67.79f, 53.84f)
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
                        moveTo(29f, 131f)
                        curveToRelative(-3.13f, -1.6f, -6.6f, -2.76f, -9.3f, -4.9f)
                        arcToRelative(94.16f, 94.16f, 0f, isMoreThanHalf = false, isPositiveArc = true, -10.14f, -9.94f)
                        curveTo(3.79f, 110f, 4f, 101.38f, 9.8f, 95.7f)
                        reflectiveCurveToRelative(14.48f, -5.46f, 20.47f, 0.36f)
                        curveToRelative(3.31f, 3.21f, 6.7f, 6.36f, 9.77f, 9.79f)
                        curveToRelative(4.08f, 4.56f, 5.13f, 9.83f, 2.62f, 15.59f)
                        curveTo(40.35f, 126.76f, 35.12f, 130.16f, 29f, 131f)
                        close()
                    }
                }
            }
        }.build()
        return _vector!!
    }

