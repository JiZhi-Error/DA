package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_filled_like_private extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
                Paint instancePaint = c.instancePaint(looper);
                instancePaint.setFlags(385);
                instancePaint.setStyle(Paint.Style.FILL);
                Paint instancePaint2 = c.instancePaint(looper);
                instancePaint2.setFlags(385);
                instancePaint2.setStyle(Paint.Style.STROKE);
                instancePaint.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint2.setStrokeWidth(1.0f);
                instancePaint2.setStrokeCap(Paint.Cap.BUTT);
                instancePaint2.setStrokeJoin(Paint.Join.MITER);
                instancePaint2.setStrokeMiter(4.0f);
                instancePaint2.setPathEffect(null);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.87176f, 18.193398f);
                instancePath.lineTo(35.030296f, 19.324907f);
                instancePath.lineTo(35.030296f, 19.324907f);
                instancePath.lineTo(35.99308f, 20.239637f);
                instancePath.lineTo(35.99308f, 20.239637f);
                instancePath.lineTo(37.380127f, 18.915659f);
                instancePath.lineTo(37.380127f, 18.915659f);
                instancePath.lineTo(38.1144f, 18.193398f);
                instancePath.lineTo(38.1144f, 18.193398f);
                instancePath.cubicTo(43.972263f, 12.335534f, 53.469738f, 12.335534f, 59.327602f, 18.193398f);
                instancePath.cubicTo(63.19652f, 22.062315f, 64.510155f, 27.518883f, 63.268497f, 32.465923f);
                instancePath.lineTo(63.123005f, 32.98633f);
                instancePath.cubicTo(62.21738f, 32.16394f, 61.068356f, 31.642761f, 59.809128f, 31.525316f);
                instancePath.lineTo(59.263103f, 31.5f);
                instancePath.lineTo(44.236897f, 31.5f);
                instancePath.lineTo(43.79983f, 31.51607f);
                instancePath.cubicTo(40.770462f, 31.739708f, 38.4f, 34.26973f, 38.4f, 37.35f);
                instancePath.cubicTo(38.4f, 39.16159f, 39.21829f, 40.779266f, 40.50518f, 41.848804f);
                instancePath.cubicTo(39.21721f, 42.922523f, 38.4f, 44.541412f, 38.4f, 46.35f);
                instancePath.cubicTo(38.4f, 48.16159f, 39.21829f, 49.779266f, 40.50518f, 50.848804f);
                instancePath.cubicTo(39.21721f, 51.922523f, 38.4f, 53.541412f, 38.4f, 55.35f);
                instancePath.cubicTo(38.4f, 56.74649f, 38.886253f, 58.027756f, 39.698826f, 59.032906f);
                instancePath.lineTo(38.11429f, 60.619694f);
                instancePath.cubicTo(37.032997f, 61.701305f, 35.331314f, 61.78459f, 34.154396f, 60.86958f);
                instancePath.lineTo(33.87176f, 60.619804f);
                instancePath.lineTo(12.495378f, 39.243423f);
                instancePath.cubicTo(6.801199f, 33.37236f, 6.8551817f, 23.996773f, 12.658556f, 18.193398f);
                instancePath.cubicTo(18.51642f, 12.335534f, 28.013895f, 12.335534f, 33.87176f, 18.193398f);
                instancePath.close();
                instancePath.moveTo(59.263103f, 53.1f);
                instancePath.lineTo(59.566635f, 53.120373f);
                instancePath.cubicTo(60.448925f, 53.239834f, 61.167767f, 53.873158f, 61.41119f, 54.717106f);
                instancePath.lineTo(61.47958f, 55.04287f);
                instancePath.lineTo(61.5f, 55.35f);
                instancePath.lineTo(61.479725f, 55.65531f);
                instancePath.cubicTo(61.360863f, 56.542767f, 60.73074f, 57.265823f, 59.891975f, 57.51067f);
                instancePath.lineTo(59.56825f, 57.57946f);
                instancePath.lineTo(59.263103f, 57.6f);
                instancePath.lineTo(44.236897f, 57.6f);
                instancePath.lineTo(43.933365f, 57.579624f);
                instancePath.cubicTo(42.841534f, 57.431797f, 42.0f, 56.49703f, 42.0f, 55.35f);
                instancePath.cubicTo(42.0f, 54.210915f, 42.835083f, 53.269527f, 43.93175f, 53.12054f);
                instancePath.lineTo(44.236897f, 53.1f);
                instancePath.lineTo(59.263103f, 53.1f);
                instancePath.close();
                instancePath.moveTo(59.263103f, 44.1f);
                instancePath.lineTo(59.566635f, 44.120373f);
                instancePath.cubicTo(60.448925f, 44.239834f, 61.167767f, 44.873158f, 61.41119f, 45.717106f);
                instancePath.lineTo(61.47958f, 46.04287f);
                instancePath.lineTo(61.5f, 46.35f);
                instancePath.lineTo(61.479725f, 46.65531f);
                instancePath.cubicTo(61.360863f, 47.542767f, 60.73074f, 48.265823f, 59.891975f, 48.51067f);
                instancePath.lineTo(59.56825f, 48.57946f);
                instancePath.lineTo(59.263103f, 48.6f);
                instancePath.lineTo(44.236897f, 48.6f);
                instancePath.lineTo(43.933365f, 48.579624f);
                instancePath.cubicTo(42.841534f, 48.431797f, 42.0f, 47.49703f, 42.0f, 46.35f);
                instancePath.cubicTo(42.0f, 45.210915f, 42.835083f, 44.269527f, 43.93175f, 44.12054f);
                instancePath.lineTo(44.236897f, 44.1f);
                instancePath.lineTo(59.263103f, 44.1f);
                instancePath.close();
                instancePath.moveTo(59.263103f, 35.1f);
                instancePath.lineTo(59.566635f, 35.120373f);
                instancePath.cubicTo(60.448925f, 35.239834f, 61.167767f, 35.873158f, 61.41119f, 36.717106f);
                instancePath.lineTo(61.47958f, 37.04287f);
                instancePath.lineTo(61.5f, 37.35f);
                instancePath.lineTo(61.479725f, 37.65531f);
                instancePath.cubicTo(61.360863f, 38.542767f, 60.73074f, 39.265823f, 59.891975f, 39.51067f);
                instancePath.lineTo(59.56825f, 39.57946f);
                instancePath.lineTo(59.263103f, 39.6f);
                instancePath.lineTo(44.236897f, 39.6f);
                instancePath.lineTo(43.933365f, 39.579624f);
                instancePath.cubicTo(42.841534f, 39.431797f, 42.0f, 38.49703f, 42.0f, 37.35f);
                instancePath.cubicTo(42.0f, 36.210915f, 42.835083f, 35.269527f, 43.93175f, 35.12054f);
                instancePath.lineTo(44.236897f, 35.1f);
                instancePath.lineTo(59.263103f, 35.1f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
