package com.tencent.mm.plugin.festival.ui;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 «\u00022\u00020\u0001:*ª\u0002«\u0002¬\u0002­\u0002®\u0002¯\u0002°\u0002±\u0002²\u0002³\u0002´\u0002µ\u0002¶\u0002·\u0002¸\u0002¹\u0002º\u0002»\u0002¼\u0002½\u0002¾\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010×\u0001\u001a\u00020\u001e2\b\u0010Ø\u0001\u001a\u00030Ù\u00012\b\u0010Ú\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010Û\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010Ý\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010Þ\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010ß\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010à\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0012\u0010á\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001J\u0014\u0010â\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010ã\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010ä\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\u0014\u0010å\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002J\n\u0010æ\u0001\u001a\u00030Ü\u0001H\u0004J\n\u0010ç\u0001\u001a\u00030Ü\u0001H\u0002J\b\u0010è\u0001\u001a\u00030Ü\u0001J\u001c\u0010é\u0001\u001a\u00020+2\u0007\u0010ê\u0001\u001a\u00020\t2\u0007\u0010ë\u0001\u001a\u00020\tH J\u0014\u0010ì\u0001\u001a\u00030Ü\u00012\u0007\u0010í\u0001\u001a\u00020+H J.\u0010î\u0001\u001a\u00020\t2\u0007\u0010í\u0001\u001a\u00020+2\u0007\u0010ï\u0001\u001a\u00020\u00182\u0007\u0010ð\u0001\u001a\u00020\t2\u0007\u0010ñ\u0001\u001a\u00020\tH J/\u0010ò\u0001\u001a\u00020\t2\u0007\u0010í\u0001\u001a\u00020+2\b\u0010ó\u0001\u001a\u00030\u00012\u0007\u0010ô\u0001\u001a\u00020\t2\u0007\u0010õ\u0001\u001a\u00020\tH J\u0014\u0010ö\u0001\u001a\u00030Ü\u00012\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0014J\u001c\u0010÷\u0001\u001a\u00030Ü\u00012\u0007\u0010ø\u0001\u001a\u00020\t2\u0007\u0010ù\u0001\u001a\u00020\tH\u0014J\b\u0010ú\u0001\u001a\u00030Ü\u0001J\b\u0010û\u0001\u001a\u00030Ü\u0001J.\u0010ü\u0001\u001a\u00030Ü\u00012\u0007\u0010ê\u0001\u001a\u00020\t2\u0007\u0010ë\u0001\u001a\u00020\t2\u0007\u0010ý\u0001\u001a\u00020\t2\u0007\u0010þ\u0001\u001a\u00020\tH\u0014J\u0013\u0010ÿ\u0001\u001a\u0002042\b\u0010\u0002\u001a\u00030\u0002H\u0017J\n\u0010\u0002\u001a\u00030Ü\u0001H\u0002J\n\u0010\u0002\u001a\u00030Ü\u0001H\u0002J\b\u0010\u0002\u001a\u00030Ü\u0001J\b\u0010\u0002\u001a\u00030Ü\u0001J\u0013\u0010\u0002\u001a\u00030Ü\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\u0010J&\u0010\u0002\u001a\u00030Ü\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\u00132\t\u0010\u0002\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0003\u0010\u0002J\u0011\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010ï\u0001\u001a\u00020\u0018J$\u0010\u0002\u001a\u00030Ü\u00012\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010ô\u0001\u001a\u00020\t2\u0007\u0010õ\u0001\u001a\u00020\tJ\u001c\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010ó\u0001\u001a\u00020(2\u0007\u0010\u0002\u001a\u00020/H\u0002J\u001c\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010ó\u0001\u001a\u00020/2\u0007\u0010\u0002\u001a\u00020/H\u0002J7\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020/H\u0002J\u0010\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u0013J\u0019\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u0013J\u0010\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u0013J\u0019\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u00132\u0007\u0010\u0002\u001a\u00020\u0013J\b\u0010\u0002\u001a\u00030Ü\u0001J\u0013\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010\u0002\u001a\u00020\u0016H\u0007J\u0011\u0010\u0002\u001a\u00030Ü\u00012\u0007\u0010ï\u0001\u001a\u00020\u0018J$\u0010\u0002\u001a\u00030Ü\u00012\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010ô\u0001\u001a\u00020\t2\u0007\u0010õ\u0001\u001a\u00020\tJ\u0010\u0010\u0002\u001a\u00020\t2\u0007\u0010 \u0002\u001a\u00020\u0013J\u0010\u0010¡\u0002\u001a\u00020\t2\u0007\u0010¢\u0002\u001a\u00020\u0013J\u000e\u0010£\u0002\u001a\u00020\u0013*\u00030®\u0001H\u0002J\u000e\u0010¤\u0002\u001a\u00020\t*\u00030®\u0001H\u0002J\u000e\u0010¥\u0002\u001a\u00020\t*\u00030¦\u0002H\u0002J\u000e\u0010§\u0002\u001a\u00020\t*\u00030¦\u0002H\u0002J\u000e\u0010¨\u0002\u001a\u00020\u0013*\u00030®\u0001H\u0002J\u000e\u0010©\u0002\u001a\u00020\t*\u00030¦\u0002H\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+XD¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u000e\u0010=\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00106\"\u0004\b@\u00108R\u001a\u0010A\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u000e\u0012\b\u0012\u00060HR\u00020\u0000\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\"\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\"\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u000e\u0010^\u001a\u00020_X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR\u000e\u0010c\u001a\u00020dX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010e\u001a\u0002048F¢\u0006\u0006\u001a\u0004\be\u00106R\u000e\u0010f\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010h\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0011\u0010q\u001a\u00020r¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR(\u0010u\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180 \u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\"\"\u0004\bw\u0010PR\u001a\u0010x\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010S\"\u0004\bz\u0010UR\u0011\u0010{\u001a\u00020r¢\u0006\b\n\u0000\u001a\u0004\b|\u0010tR\u0018\u0010}\u001a\f\u0012\b\u0012\u00060~R\u00020\u00000GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u000b \u0001*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001d\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020\u0013@FX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010X\"\u0005\b\u0001\u0010ZR\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020_X\u0004¢\u0006\u0002\n\u0000R%\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\"\"\u0005\b¡\u0001\u0010PR\u001a\u0010¢\u0001\u001a\r\u0012\t\u0012\u00070£\u0001R\u00020\u00000GX\u000e¢\u0006\u0002\n\u0000R \u0010¤\u0001\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0013@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010XR\u0014\u0010¦\u0001\u001a\u00070§\u0001R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010¨\u0001\u001a\u00070©\u0001R\u00020\u0000¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001R*\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010­\u0001X\u000e¢\u0006\u0015\n\u0003\u0010³\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R#\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\t0 X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\"\"\u0005\b¶\u0001\u0010PR\u001c\u0010·\u0001\u001a\u000f\u0012\t\u0012\u00070¸\u0001R\u00020\u0000\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010º\u0001\u001a\t\u0018\u00010»\u0001R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010¼\u0001\u001a\u00020+X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b½\u0001\u0010-\"\u0006\b¾\u0001\u0010¿\u0001R\u0013\u0010À\u0001\u001a\u00020J¢\u0006\t\n\u0000\u001a\u0005\bÁ\u0001\u0010LR\u001d\u0010Â\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010C\"\u0005\bÄ\u0001\u0010ER\u001d\u0010Å\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010C\"\u0005\bÇ\u0001\u0010ER\u001d\u0010È\u0001\u001a\u000204X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u00106\"\u0005\bÊ\u0001\u00108R%\u0010Ë\u0001\u001a\u0004\u0018\u00010/2\b\u0010\u000f\u001a\u0004\u0018\u00010/@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0014\u0010Î\u0001\u001a\u00020/¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010Í\u0001R\u001d\u0010Ð\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010X\"\u0005\bÒ\u0001\u0010ZR \u0010Ó\u0001\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0013@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\bÔ\u0001\u0010XR\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006¿\u0002"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LightNDark", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$LightNDarkLogic;", "getLightNDark", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$LightNDarkLogic;", "<set-?>", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslate;", "animatingScaleAndTranslate", "animatingScaleStart", "", "Ljava/lang/Float;", "animatingTranslateStart", "Landroid/graphics/PointF;", "backgroundBitmap", "Landroid/graphics/Bitmap;", "getBackgroundBitmap", "()Landroid/graphics/Bitmap;", "setBackgroundBitmap", "(Landroid/graphics/Bitmap;)V", "backgroundBitmapPaint", "Landroid/graphics/Paint;", "backgroundGradientDarkColors", "", "getBackgroundGradientDarkColors", "()Ljava/util/List;", "backgroundGradientLightColors", "getBackgroundGradientLightColors", "backgroundGradientPaintDark", "backgroundGradientPaintLight", "backgroundRectDst", "Landroid/graphics/Rect;", "backgroundRectSrc", "clickRippleDuration", "", "getClickRippleDuration", "()J", "dataStarDstRectF", "Landroid/graphics/RectF;", "dataStarPaint", "dataStarPaintAlpha", "dataStarSrcRect", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "debugPaint", "debugWish", "getDebugWish", "setDebugWish", Constants.PARAM_DENSITY, "draggable", "getDraggable", "setDraggable", "drawEffect", "getDrawEffect", "()I", "setDrawEffect", "(I)V", "flashStar", "", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStar;", "flashStarAnimConfig", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStarAnimConfig;", "getFlashStarAnimConfig", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStarAnimConfig;", "flashStarBitmap", "getFlashStarBitmap", "setFlashStarBitmap", "(Ljava/util/List;)V", "flashStarPaint", "getFlashStarPaint", "()Landroid/graphics/Paint;", "setFlashStarPaint", "(Landroid/graphics/Paint;)V", "flashStarSensorOffsetX", "getFlashStarSensorOffsetX", "()F", "setFlashStarSensorOffsetX", "(F)V", "flashStarSensorOffsetY", "getFlashStarSensorOffsetY", "setFlashStarSensorOffsetY", "flingInterpolator", "Landroid/animation/TimeInterpolator;", "flingRatio", "getFlingRatio", "setFlingRatio", "gesture", "Landroid/view/GestureDetector;", "isAnimating", "isFlinging", "isScrolling", "lastTouchUpPointRaw", "getLastTouchUpPointRaw", "()Landroid/graphics/PointF;", "logger", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$Logger;", "getLogger", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$Logger;", "setLogger", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight$Logger;)V", "meteorAnimConfig", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$MeteorAnimConfig;", "getMeteorAnimConfig", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$MeteorAnimConfig;", "meteorBitmap", "getMeteorBitmap", "setMeteorBitmap", "meteorPaint", "getMeteorPaint", "setMeteorPaint", "meteorShowerAnimConfig", "getMeteorShowerAnimConfig", "meteors", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$Meteor;", "nativeHelper", "normalStarBitmap", "kotlin.jvm.PlatformType", "normalStarSensorOffsetX", "getNormalStarSensorOffsetX", "setNormalStarSensorOffsetX", "normalStarSensorOffsetY", "getNormalStarSensorOffsetY", "setNormalStarSensorOffsetY", "onCanvasClickListener", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnCanvasClickListener;", "getOnCanvasClickListener", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnCanvasClickListener;", "setOnCanvasClickListener", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnCanvasClickListener;)V", "onViewPortChangedListener", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnViewPortChangedListener;", "getOnViewPortChangedListener", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnViewPortChangedListener;", "setOnViewPortChangedListener", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnViewPortChangedListener;)V", "pixelsCache", "", "value", "radiusCorner", "getRadiusCorner", "setRadiusCorner", "radiusCornerPath", "Landroid/graphics/Path;", "random", "Lkotlin/random/Random;", "revertFlingInterpolator", "rippleBitmap", "getRippleBitmap", "setRippleBitmap", "rippleList", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$RippleAnimator;", "scale", "getScale", "scaleAndTranslateListener", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslateListener;", "sensor", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$Sensor;", "getSensor", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$Sensor;", "shinyStarAnimConfigs", "", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;", "getShinyStarAnimConfigs", "()[Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;", "setShinyStarAnimConfigs", "([Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;)V", "[Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;", "shinyStarColors", "getShinyStarColors", "setShinyStarColors", "shinyStars", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStar;", "shouldSpringBack", "smoothUpdateBitmap", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmap;", "smoothUpdateStarBitmapIntervalMs", "getSmoothUpdateStarBitmapIntervalMs", "setSmoothUpdateStarBitmapIntervalMs", "(J)V", "specificFlashStarAnimConfig", "getSpecificFlashStarAnimConfig", "srcHeight", "getSrcHeight", "setSrcHeight", "srcWidth", "getSrcWidth", "setSrcWidth", "touchable", "getTouchable", "setTouchable", "vRect", "getVRect", "()Landroid/graphics/RectF;", "vRectDefault", "getVRectDefault", "vRectOffsetY", "getVRectOffsetY", "setVRectOffsetY", "vScaleDefault", "getVScaleDefault", "vTranslate", "vTranslateRaw", "createBackgroundGradientPaint", "canvas", "Landroid/graphics/Canvas;", "colors", "drawBackground", "", "drawBackgroundWithBitmap", "drawBackgroundWithGradient", "drawDataStar", "drawFlashStar", "drawMeteor", "drawRadiusCorner", "drawRipple", "drawShinyStar", "drawVRectIfDebug", "finalize", "initializeLayout", "meteorShower", "nativeCreate", "w", "h", "nativeRelease", "ptr", "nativeUpdateDst", "bitmap", "from", "to", "nativeUpdateSrc", "src", "width", "height", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "onSizeChanged", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "prepareDebugPaint", "randomStarIfNeeded", "release", "reset", "setScaleAndTranslate", "sat", "_scale", "_vTrans", "(Ljava/lang/Float;Landroid/graphics/PointF;)V", "smoothUpdateStarBitmap", "pixels", "sourceToViewRect", "dst", "left", "top", "right", "bottom", "sourceToViewX", "sx", "sourceToViewXSensor", "sensorOffsetX", "sourceToViewY", "sy", "sourceToViewYSensor", "sensorOffset", "springBack", "startFlashStar", "position", "updateStarBitmap", "viewToSourceX", "vx", "viewToSourceY", "vy", "getRandomAlpha", "getRandomColor", "getRandomDelayMs", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "getRandomDurationMs", "getRandomRadius", "getRandomStartDelayMs", "AnimConfig", "Companion", "DelayedAnimation", "FlashStar", "FlashStarAnimConfig", "LightNDarkLogic", "Logger", "Meteor", "MeteorAnimConfig", "OnCanvasClickListener", "OnViewPortChangedListener", "RippleAnimator", "ScaleAndTranslate", "ScaleAndTranslateListener", "Sensor", "SensorInterpreter", "ShinyStar", "ShinyStarConfig", "SmoothUpdateBitmap", "SmoothUpdateBitmapListener", "Time", "plugin-festival_release"})
public final class StarryNight extends View {
    public static final b UDl = new b((byte) 0);
    private boolean CJo;
    private boolean JUj;
    private final GestureDetector ORf;
    private RectF UCA;
    private float UCB;
    private final RectF UCC;
    private float UCD;
    private boolean UCE;
    private final PointF UCF;
    private int UCG;
    private final kotlin.j.c UCH;
    private Path UCI;
    private final long UCJ;
    private List<l> UCK;
    private Paint UCL;
    private Paint UCM;
    private final Paint UCN;
    private final Rect UCO;
    private final Rect UCP;
    private final int[] UCQ;
    private long UCR;
    s UCS;
    private final Paint UCT;
    private final Paint UCU;
    private final Rect UCV;
    private final RectF UCW;
    private List<q> UCX;
    private Paint UCY;
    public List<d> UCZ;
    private float UCb;
    g UCc;
    private boolean UCd = true;
    private float UCe = 0.0625f;
    private long UCf = 10000;
    private j UCg;
    private k UCh;
    private Bitmap UCi;
    private final List<Integer> UCj;
    private final List<Integer> UCk;
    private List<Bitmap> UCl;
    private List<? extends List<Bitmap>> UCm;
    private final i UCn;
    private final i UCo;
    private List<Bitmap> UCp;
    private final e UCq;
    public final e UCr;
    private int UCs;
    private int UCt;
    private float UCu;
    private float UCv;
    private r[] UCw;
    private List<Integer> UCx;
    final Bitmap UCy;
    private PointF UCz;
    private Paint UDa;
    private List<h> UDb;
    private final f UDc;
    private final o UDd;
    private boolean UDe;
    private final TimeInterpolator UDf;
    private final TimeInterpolator UDg;
    private m UDh;
    private Float UDi;
    private PointF UDj;
    private n UDk;
    private PointF aXO;
    private boolean aXs;
    private final float density;
    private Paint iY;
    private boolean lSW;
    private float scale;
    int srcHeight;
    int srcWidth;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$Logger;", "", "e", "", "tag", "", "log", "i", "plugin-festival_release"})
    public interface g {
        void e(String str, String str2);

        void i(String str, String str2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnCanvasClickListener;", "", "onCanvasRegionClick", "", "sx", "", "sy", "onInvalidRegionClick", "", "vx", "", "vy", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "plugin-festival_release"})
    public interface j {
        void aM(float f2, float f3);

        boolean kM(int i2, int i3);

        void onTouchEvent(MotionEvent motionEvent);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$OnViewPortChangedListener;", "", "onViewPortChanged", "", "plugin-festival_release"})
    public interface k {
        void dDa();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmapListener;", "", "onEnd", "", "plugin-festival_release"})
    public interface t {
    }

    static {
        AppMethodBeat.i(263325);
        AppMethodBeat.o(263325);
    }

    private final native long nativeCreate(int i2, int i3);

    private final native void nativeRelease(long j2);

    private final native int nativeUpdateDst(long j2, Bitmap bitmap, int i2, int i3);

    private final native int nativeUpdateSrc(long j2, int[] iArr, int i2, int i3);

    public static final /* synthetic */ int a(StarryNight starryNight, long j2, Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(263327);
        int nativeUpdateDst = starryNight.nativeUpdateDst(j2, bitmap, i2, i3);
        AppMethodBeat.o(263327);
        return nativeUpdateDst;
    }

    public static final /* synthetic */ int a(StarryNight starryNight, long j2, int[] iArr, int i2, int i3) {
        AppMethodBeat.i(263326);
        int nativeUpdateSrc = starryNight.nativeUpdateSrc(j2, iArr, i2, i3);
        AppMethodBeat.o(263326);
        return nativeUpdateSrc;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNight(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(263322);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        Resources resources = context2.getResources();
        kotlin.g.b.p.g(resources, "context.resources");
        this.density = resources.getDisplayMetrics().density;
        String[] strArr = {"#140E3E", "#1B396B", "#1F5183"};
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(Integer.valueOf(Color.parseColor(strArr[i2])));
        }
        this.UCj = arrayList;
        String[] strArr2 = {"#070435", "#19144C", "#200E44"};
        ArrayList arrayList2 = new ArrayList(3);
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList2.add(Integer.valueOf(Color.parseColor(strArr2[i3])));
        }
        this.UCk = arrayList2;
        this.UCn = new i(true, 10000, 18000);
        i iVar = new i(false, 1000, 3000);
        iVar.b(new kotlin.k.f(3, 5));
        iVar.a(new kotlin.k.f(1000, 1500));
        this.UCo = iVar;
        this.UCq = new e(3, 1000);
        e eVar = new e(1, 0);
        eVar.dqT = false;
        eVar.tEJ = 1.8f;
        eVar.UDw = false;
        this.UCr = eVar;
        this.UCu = 20.0f * this.density;
        this.UCv = 20.0f * this.density;
        this.UCw = new r[]{new r(-30.0f * this.density, -30.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.1f, 0.3f, 200), new r(5.0f * this.density, 5.0f * this.density, 1.5f * this.density, 1.5f * this.density, 0.1f, 0.3f, 30), new r(10.0f * this.density, 10.0f * this.density, 0.25f * this.density, 0.25f * this.density, 0.1f, 0.3f, 100), new r(20.0f * this.density, 20.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.4f, 0.6f, 200), new r(30.0f * this.density, 30.0f * this.density, 0.75f * this.density, 0.5f * this.density, 0.4f, 0.6f, 100)};
        String[] strArr3 = {"#8F3940", "#393730", "#153FBF", "#5BE6EA", "#8C2A9A"};
        ArrayList arrayList3 = new ArrayList(5);
        for (int i4 = 0; i4 < 5; i4++) {
            arrayList3.add(Integer.valueOf(Color.parseColor(strArr3[i4])));
        }
        this.UCx = arrayList3;
        this.srcWidth = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.srcHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.UCy = Bitmap.createBitmap(this.srcWidth, this.srcHeight, Bitmap.Config.ARGB_8888);
        this.scale = 1.0f;
        this.UCB = 1.0f;
        this.UCC = new RectF();
        this.UCD = -80.0f * this.density;
        kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
        float hYV = kotlin.g.b.l.hYV();
        kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
        this.UCF = new PointF(hYV, kotlin.g.b.l.hYV());
        this.UCG = 1;
        this.UCH = kotlin.j.d.Pf(System.currentTimeMillis());
        this.UCJ = 650;
        this.UCK = new ArrayList();
        this.UCN = new Paint();
        this.UCN.setAntiAlias(true);
        this.UCO = new Rect();
        this.UCP = new Rect();
        this.UCQ = new int[(this.srcWidth * this.srcHeight)];
        this.UCR = nativeCreate(this.srcWidth, this.srcHeight);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(false);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        this.UCT = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setAlpha(25);
        this.UCU = paint2;
        this.UCV = new Rect();
        this.UCW = new RectF();
        this.UCY = new Paint();
        this.UCY.setAntiAlias(true);
        this.UDa = new Paint();
        this.UDa.setAntiAlias(true);
        this.UDb = new ArrayList();
        this.UDc = new f();
        Context context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        this.UDd = new o(this, context3);
        this.UDf = v.UEn;
        this.UDg = y.UEt;
        this.ORf = new GestureDetector(getContext(), new w(this));
        this.UDk = new n();
        AppMethodBeat.o(263322);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(263323);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        Resources resources = context2.getResources();
        kotlin.g.b.p.g(resources, "context.resources");
        this.density = resources.getDisplayMetrics().density;
        String[] strArr = {"#140E3E", "#1B396B", "#1F5183"};
        ArrayList arrayList = new ArrayList(3);
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(Integer.valueOf(Color.parseColor(strArr[i2])));
        }
        this.UCj = arrayList;
        String[] strArr2 = {"#070435", "#19144C", "#200E44"};
        ArrayList arrayList2 = new ArrayList(3);
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList2.add(Integer.valueOf(Color.parseColor(strArr2[i3])));
        }
        this.UCk = arrayList2;
        this.UCn = new i(true, 10000, 18000);
        i iVar = new i(false, 1000, 3000);
        iVar.b(new kotlin.k.f(3, 5));
        iVar.a(new kotlin.k.f(1000, 1500));
        this.UCo = iVar;
        this.UCq = new e(3, 1000);
        e eVar = new e(1, 0);
        eVar.dqT = false;
        eVar.tEJ = 1.8f;
        eVar.UDw = false;
        this.UCr = eVar;
        this.UCu = 20.0f * this.density;
        this.UCv = 20.0f * this.density;
        this.UCw = new r[]{new r(-30.0f * this.density, -30.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.1f, 0.3f, 200), new r(5.0f * this.density, 5.0f * this.density, 1.5f * this.density, 1.5f * this.density, 0.1f, 0.3f, 30), new r(10.0f * this.density, 10.0f * this.density, 0.25f * this.density, 0.25f * this.density, 0.1f, 0.3f, 100), new r(20.0f * this.density, 20.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.4f, 0.6f, 200), new r(30.0f * this.density, 30.0f * this.density, 0.75f * this.density, 0.5f * this.density, 0.4f, 0.6f, 100)};
        String[] strArr3 = {"#8F3940", "#393730", "#153FBF", "#5BE6EA", "#8C2A9A"};
        ArrayList arrayList3 = new ArrayList(5);
        for (int i4 = 0; i4 < 5; i4++) {
            arrayList3.add(Integer.valueOf(Color.parseColor(strArr3[i4])));
        }
        this.UCx = arrayList3;
        this.srcWidth = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.srcHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.UCy = Bitmap.createBitmap(this.srcWidth, this.srcHeight, Bitmap.Config.ARGB_8888);
        this.scale = 1.0f;
        this.UCB = 1.0f;
        this.UCC = new RectF();
        this.UCD = -80.0f * this.density;
        kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
        float hYV = kotlin.g.b.l.hYV();
        kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
        this.UCF = new PointF(hYV, kotlin.g.b.l.hYV());
        this.UCG = 1;
        this.UCH = kotlin.j.d.Pf(System.currentTimeMillis());
        this.UCJ = 650;
        this.UCK = new ArrayList();
        this.UCN = new Paint();
        this.UCN.setAntiAlias(true);
        this.UCO = new Rect();
        this.UCP = new Rect();
        this.UCQ = new int[(this.srcWidth * this.srcHeight)];
        this.UCR = nativeCreate(this.srcWidth, this.srcHeight);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(false);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        this.UCT = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setAlpha(25);
        this.UCU = paint2;
        this.UCV = new Rect();
        this.UCW = new RectF();
        this.UCY = new Paint();
        this.UCY.setAntiAlias(true);
        this.UDa = new Paint();
        this.UDa.setAntiAlias(true);
        this.UDb = new ArrayList();
        this.UDc = new f();
        Context context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        this.UDd = new o(this, context3);
        this.UDf = v.UEn;
        this.UDg = y.UEt;
        this.ORf = new GestureDetector(getContext(), new w(this));
        this.UDk = new n();
        AppMethodBeat.o(263323);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNight(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(263324);
        Context context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        Resources resources = context2.getResources();
        kotlin.g.b.p.g(resources, "context.resources");
        this.density = resources.getDisplayMetrics().density;
        String[] strArr = {"#140E3E", "#1B396B", "#1F5183"};
        ArrayList arrayList = new ArrayList(3);
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(Integer.valueOf(Color.parseColor(strArr[i3])));
        }
        this.UCj = arrayList;
        String[] strArr2 = {"#070435", "#19144C", "#200E44"};
        ArrayList arrayList2 = new ArrayList(3);
        for (int i4 = 0; i4 < 3; i4++) {
            arrayList2.add(Integer.valueOf(Color.parseColor(strArr2[i4])));
        }
        this.UCk = arrayList2;
        this.UCn = new i(true, 10000, 18000);
        i iVar = new i(false, 1000, 3000);
        iVar.b(new kotlin.k.f(3, 5));
        iVar.a(new kotlin.k.f(1000, 1500));
        this.UCo = iVar;
        this.UCq = new e(3, 1000);
        e eVar = new e(1, 0);
        eVar.dqT = false;
        eVar.tEJ = 1.8f;
        eVar.UDw = false;
        this.UCr = eVar;
        this.UCu = 20.0f * this.density;
        this.UCv = 20.0f * this.density;
        this.UCw = new r[]{new r(-30.0f * this.density, -30.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.1f, 0.3f, 200), new r(5.0f * this.density, 5.0f * this.density, 1.5f * this.density, 1.5f * this.density, 0.1f, 0.3f, 30), new r(10.0f * this.density, 10.0f * this.density, 0.25f * this.density, 0.25f * this.density, 0.1f, 0.3f, 100), new r(20.0f * this.density, 20.0f * this.density, 0.5f * this.density, 0.5f * this.density, 0.4f, 0.6f, 200), new r(30.0f * this.density, 30.0f * this.density, 0.75f * this.density, 0.5f * this.density, 0.4f, 0.6f, 100)};
        String[] strArr3 = {"#8F3940", "#393730", "#153FBF", "#5BE6EA", "#8C2A9A"};
        ArrayList arrayList3 = new ArrayList(5);
        for (int i5 = 0; i5 < 5; i5++) {
            arrayList3.add(Integer.valueOf(Color.parseColor(strArr3[i5])));
        }
        this.UCx = arrayList3;
        this.srcWidth = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.srcHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
        this.UCy = Bitmap.createBitmap(this.srcWidth, this.srcHeight, Bitmap.Config.ARGB_8888);
        this.scale = 1.0f;
        this.UCB = 1.0f;
        this.UCC = new RectF();
        this.UCD = -80.0f * this.density;
        kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
        float hYV = kotlin.g.b.l.hYV();
        kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
        this.UCF = new PointF(hYV, kotlin.g.b.l.hYV());
        this.UCG = 1;
        this.UCH = kotlin.j.d.Pf(System.currentTimeMillis());
        this.UCJ = 650;
        this.UCK = new ArrayList();
        this.UCN = new Paint();
        this.UCN.setAntiAlias(true);
        this.UCO = new Rect();
        this.UCP = new Rect();
        this.UCQ = new int[(this.srcWidth * this.srcHeight)];
        this.UCR = nativeCreate(this.srcWidth, this.srcHeight);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(false);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        this.UCT = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setAlpha(25);
        this.UCU = paint2;
        this.UCV = new Rect();
        this.UCW = new RectF();
        this.UCY = new Paint();
        this.UCY.setAntiAlias(true);
        this.UDa = new Paint();
        this.UDa.setAntiAlias(true);
        this.UDb = new ArrayList();
        this.UDc = new f();
        Context context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        this.UDd = new o(this, context3);
        this.UDf = v.UEn;
        this.UDg = y.UEt;
        this.ORf = new GestureDetector(getContext(), new w(this));
        this.UDk = new n();
        AppMethodBeat.o(263324);
    }

    public final float getRadiusCorner() {
        return this.UCb;
    }

    public final void setRadiusCorner(float f2) {
        this.UCI = null;
        this.UCb = f2;
    }

    public final g getLogger() {
        return this.UCc;
    }

    public final void setLogger(g gVar) {
        this.UCc = gVar;
    }

    public final boolean getTouchable() {
        return this.UCd;
    }

    public final void setTouchable(boolean z2) {
        this.UCd = z2;
    }

    public final boolean getDraggable() {
        return this.lSW;
    }

    public final void setDraggable(boolean z2) {
        this.lSW = z2;
    }

    public final float getFlingRatio() {
        return this.UCe;
    }

    public final void setFlingRatio(float f2) {
        this.UCe = f2;
    }

    public final long getSmoothUpdateStarBitmapIntervalMs() {
        return this.UCf;
    }

    public final void setSmoothUpdateStarBitmapIntervalMs(long j2) {
        this.UCf = j2;
    }

    public final j getOnCanvasClickListener() {
        return this.UCg;
    }

    public final void setOnCanvasClickListener(j jVar) {
        this.UCg = jVar;
    }

    public final k getOnViewPortChangedListener() {
        return this.UCh;
    }

    public final void setOnViewPortChangedListener(k kVar) {
        this.UCh = kVar;
    }

    public final Bitmap getBackgroundBitmap() {
        return this.UCi;
    }

    public final void setBackgroundBitmap(Bitmap bitmap) {
        this.UCi = bitmap;
    }

    public final List<Integer> getBackgroundGradientLightColors() {
        return this.UCj;
    }

    public final List<Integer> getBackgroundGradientDarkColors() {
        return this.UCk;
    }

    public final List<Bitmap> getRippleBitmap() {
        return this.UCl;
    }

    public final void setRippleBitmap(List<Bitmap> list) {
        this.UCl = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends java.util.List<android.graphics.Bitmap>>, java.util.List<java.util.List<android.graphics.Bitmap>> */
    public final List<List<Bitmap>> getMeteorBitmap() {
        return this.UCm;
    }

    public final void setMeteorBitmap(List<? extends List<Bitmap>> list) {
        this.UCm = list;
    }

    public final i getMeteorAnimConfig() {
        return this.UCn;
    }

    public final i getMeteorShowerAnimConfig() {
        return this.UCo;
    }

    public final List<Bitmap> getFlashStarBitmap() {
        return this.UCp;
    }

    public final void setFlashStarBitmap(List<Bitmap> list) {
        this.UCp = list;
    }

    public final e getFlashStarAnimConfig() {
        return this.UCq;
    }

    public final e getSpecificFlashStarAnimConfig() {
        return this.UCr;
    }

    public final int getNormalStarSensorOffsetX() {
        return this.UCs;
    }

    public final void setNormalStarSensorOffsetX(int i2) {
        this.UCs = i2;
    }

    public final int getNormalStarSensorOffsetY() {
        return this.UCt;
    }

    public final void setNormalStarSensorOffsetY(int i2) {
        this.UCt = i2;
    }

    public final float getFlashStarSensorOffsetX() {
        return this.UCu;
    }

    public final void setFlashStarSensorOffsetX(float f2) {
        this.UCu = f2;
    }

    public final float getFlashStarSensorOffsetY() {
        return this.UCv;
    }

    public final void setFlashStarSensorOffsetY(float f2) {
        this.UCv = f2;
    }

    public final r[] getShinyStarAnimConfigs() {
        return this.UCw;
    }

    public final void setShinyStarAnimConfigs(r[] rVarArr) {
        AppMethodBeat.i(263295);
        kotlin.g.b.p.h(rVarArr, "<set-?>");
        this.UCw = rVarArr;
        AppMethodBeat.o(263295);
    }

    public final List<Integer> getShinyStarColors() {
        return this.UCx;
    }

    public final void setShinyStarColors(List<Integer> list) {
        AppMethodBeat.i(263296);
        kotlin.g.b.p.h(list, "<set-?>");
        this.UCx = list;
        AppMethodBeat.o(263296);
    }

    public final int getSrcWidth() {
        return this.srcWidth;
    }

    public final void setSrcWidth(int i2) {
        this.srcWidth = i2;
    }

    public final int getSrcHeight() {
        return this.srcHeight;
    }

    public final void setSrcHeight(int i2) {
        this.srcHeight = i2;
    }

    public final float getScale() {
        return this.scale;
    }

    public final RectF getVRect() {
        return this.UCA;
    }

    public final float getVScaleDefault() {
        return this.UCB;
    }

    public final RectF getVRectDefault() {
        return this.UCC;
    }

    public final float getVRectOffsetY() {
        return this.UCD;
    }

    public final void setVRectOffsetY(float f2) {
        this.UCD = f2;
    }

    public final boolean getDebug() {
        return this.aXs;
    }

    public final void setDebug(boolean z2) {
        this.aXs = z2;
    }

    public final boolean getDebugWish() {
        return this.UCE;
    }

    public final void setDebugWish(boolean z2) {
        this.UCE = z2;
    }

    public final PointF getLastTouchUpPointRaw() {
        return this.UCF;
    }

    public final int getDrawEffect() {
        return this.UCG;
    }

    public final void setDrawEffect(int i2) {
        this.UCG = i2;
    }

    public final long getClickRippleDuration() {
        return this.UCJ;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$RippleAnimator;", "", "x", "", "y", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;FF)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "destRect", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "rippleRadius", "getRippleRadius", "()F", "srcRect", "Landroid/graphics/Rect;", "getX", "getY", "draw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-festival_release"})
    public final class l {
        private final float UDI;
        final Rect UDJ = new Rect(0, 0, com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX);
        final RectF UDK = new RectF(this.x - this.UDI, this.y - this.UDI, this.x + this.UDI, this.y + this.UDI);
        final ValueAnimator animator;
        final Paint paint;
        private final float x;
        private final float y;

        public l(float f2, float f3) {
            AppMethodBeat.i(263256);
            this.x = f2;
            this.y = f3;
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 30);
            ofInt.setDuration(StarryNight.this.getClickRippleDuration());
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.addListener(new a(this));
            ofInt.start();
            this.animator = ofInt;
            this.UDI = 76.0f * StarryNight.this.density;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            this.paint = paint2;
            AppMethodBeat.o(263256);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/ui/StarryNight$RippleAnimator$animator$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
        public static final class a implements Animator.AnimatorListener {
            final /* synthetic */ l UDL;

            a(l lVar) {
                this.UDL = lVar;
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(263252);
                kotlin.g.b.p.h(animator, "animation");
                AppMethodBeat.o(263252);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(263253);
                kotlin.g.b.p.h(animator, "animation");
                StarryNight.this.UCK.remove(this.UDL);
                AppMethodBeat.o(263253);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(263254);
                kotlin.g.b.p.h(animator, "animation");
                AppMethodBeat.o(263254);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(263255);
                kotlin.g.b.p.h(animator, "animation");
                StarryNight.this.UCK.remove(this.UDL);
                AppMethodBeat.o(263255);
            }
        }
    }

    private final void C(Canvas canvas) {
        AppMethodBeat.i(263298);
        for (T t2 : this.UCK) {
            kotlin.g.b.p.h(canvas, "canvas");
            if (StarryNight.this.getRippleBitmap() != null) {
                ValueAnimator valueAnimator = t2.animator;
                kotlin.g.b.p.g(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(263298);
                    throw tVar;
                }
                int intValue = ((Integer) animatedValue).intValue();
                List<Bitmap> rippleBitmap = StarryNight.this.getRippleBitmap();
                if (rippleBitmap == null) {
                    kotlin.g.b.p.hyc();
                }
                canvas.drawBitmap(rippleBitmap.get(intValue), t2.UDJ, t2.UDK, t2.paint);
            }
        }
        AppMethodBeat.o(263298);
    }

    private static Paint a(Canvas canvas, int[] iArr) {
        AppMethodBeat.i(263299);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) canvas.getHeight(), iArr, kotlin.a.e.b(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.7f), Float.valueOf(1.0f)}), Shader.TileMode.CLAMP));
        AppMethodBeat.o(263299);
        return paint;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(263300);
        super.onMeasure(i2, i3);
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "onMeasure  measuredWidth = " + getMeasuredWidth() + ", measuredHeight = " + getMeasuredHeight());
            AppMethodBeat.o(263300);
            return;
        }
        AppMethodBeat.o(263300);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(263301);
        super.onSizeChanged(i2, i3, i4, i5);
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "onSizeChanged");
        }
        b.hSl();
        g gVar2 = this.UCc;
        if (gVar2 != null) {
            gVar2.i("StarryNight", "reset");
        }
        this.UCX = null;
        this.scale = 1.0f;
        this.aXO = null;
        setScaleAndTranslate(null);
        AppMethodBeat.o(263301);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(263302);
        release();
        AppMethodBeat.o(263302);
    }

    public final void release() {
        AppMethodBeat.i(263303);
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "dl: release");
        }
        if (this.UCR != 0) {
            nativeRelease(this.UCR);
            this.UCR = 0;
        }
        AppMethodBeat.o(263303);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmap;", "", "pixels", "", "width", "", "height", "l", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmapListener;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;[IIILcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmapListener;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "getHeight", "()I", "lastUpdateIndex", "length", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmapListener;", "getPixels", "()[I", "getWidth", "plugin-festival_release"})
    public final class s {
        final /* synthetic */ StarryNight UDs;
        private final t UEi;
        int UEj;
        final ValueAnimator animator;
        private final int height;
        final int length;
        private final int[] pixels;
        private final int width;

        /* JADX WARN: Incorrect types in method signature: ([IIILcom/tencent/mm/plugin/festival/ui/StarryNight$t;)V */
        private s(StarryNight starryNight, int[] iArr, int i2, int i3) {
            g logger;
            kotlin.g.b.p.h(iArr, "pixels");
            this.UDs = starryNight;
            AppMethodBeat.i(263274);
            this.pixels = iArr;
            this.width = i2;
            this.height = i3;
            this.length = this.width * this.height;
            if (this.pixels.length != this.width * this.height) {
                IllegalStateException illegalStateException = new IllegalStateException("SmoothUpdateBitmap not work, " + this.pixels.length + ' ' + this.width + ' ' + this.height);
                AppMethodBeat.o(263274);
                throw illegalStateException;
            }
            if (starryNight.UCR != 0) {
                int a2 = StarryNight.a(starryNight, starryNight.UCR, this.pixels, this.width, this.height);
                if (a2 < 0 && (logger = starryNight.getLogger()) != null) {
                    logger.i("StarryNight", "dl: nativeUpdateSrc: ".concat(String.valueOf(a2)));
                }
            } else {
                g logger2 = starryNight.getLogger();
                if (logger2 != null) {
                    logger2.i("StarryNight", "dl: nativeUpdateSrc: smooth update bitmap after release");
                }
            }
            this.UEi = null;
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (this.width * this.height) - 1);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(this.UDs.getSmoothUpdateStarBitmapIntervalMs());
            g logger3 = this.UDs.getLogger();
            if (logger3 != null) {
                logger3.i("StarryNight", "dl: smoothUpdateStarBitmapIntervalMs: " + this.UDs.getSmoothUpdateStarBitmapIntervalMs());
            }
            ofInt.addUpdateListener(new a(this));
            ofInt.addListener(new b(this));
            this.animator = ofInt;
            AppMethodBeat.o(263274);
        }

        public /* synthetic */ s(StarryNight starryNight, int[] iArr, int i2, int i3, byte b2) {
            this(starryNight, iArr, i2, i3);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmap$animator$1$1"})
        static final class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ s UEk;

            a(s sVar) {
                this.UEk = sVar;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g logger;
                g logger2;
                AppMethodBeat.i(263273);
                kotlin.g.b.p.g(valueAnimator, LocaleUtil.ITALIAN);
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(263273);
                    throw tVar;
                }
                int intValue = ((Integer) animatedValue).intValue();
                if (this.UEk.UEj >= this.UEk.length || intValue >= this.UEk.length || this.UEk.UEj > intValue) {
                    AppMethodBeat.o(263273);
                } else if (this.UEk.UDs.UCy == null || this.UEk.UDs.UCy.isRecycled()) {
                    AppMethodBeat.o(263273);
                } else if (this.UEk.UDs.UCR == 0) {
                    AppMethodBeat.o(263273);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    int a2 = StarryNight.a(this.UEk.UDs, this.UEk.UDs.UCR, this.UEk.UDs.UCy, this.UEk.UEj, intValue);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - currentTimeMillis > 16 && (logger2 = this.UEk.UDs.getLogger()) != null) {
                        logger2.e("StarryNight", "dl: nativeUpdateDst: skip frame " + (currentTimeMillis2 - currentTimeMillis) + ' ' + (intValue - this.UEk.UEj) + ' ' + intValue);
                    }
                    if (a2 < 0 && (logger = this.UEk.UDs.getLogger()) != null) {
                        logger.i("StarryNight", "dl: nativeUpdateDst: ".concat(String.valueOf(a2)));
                    }
                    this.UEk.UEj = intValue + 1;
                    this.UEk.UDs.invalidate();
                    AppMethodBeat.o(263273);
                }
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/ui/StarryNight$SmoothUpdateBitmap$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
        public static final class b implements Animator.AnimatorListener {
            final /* synthetic */ s UEk;

            b(s sVar) {
                this.UEk = sVar;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
            }
        }
    }

    public final int aZ(float f2) {
        PointF pointF = this.aXO;
        if (pointF == null) {
            return Integer.MIN_VALUE;
        }
        return (int) ((f2 - pointF.x) / this.scale);
    }

    public final int cV(float f2) {
        PointF pointF = this.aXO;
        if (pointF == null) {
            return Integer.MIN_VALUE;
        }
        return (int) ((f2 - pointF.y) / this.scale);
    }

    public final float Y(float f2) {
        AppMethodBeat.i(263304);
        PointF pointF = this.aXO;
        if (pointF == null) {
            kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
            float hYV = kotlin.g.b.l.hYV();
            AppMethodBeat.o(263304);
            return hYV;
        }
        float f3 = pointF.x + (this.scale * f2);
        AppMethodBeat.o(263304);
        return f3;
    }

    public final float Z(float f2) {
        AppMethodBeat.i(263305);
        PointF pointF = this.aXO;
        if (pointF == null) {
            kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
            float hYV = kotlin.g.b.l.hYV();
            AppMethodBeat.o(263305);
            return hYV;
        }
        float f3 = pointF.y + (this.scale * f2);
        AppMethodBeat.o(263305);
        return f3;
    }

    private float aP(float f2, float f3) {
        AppMethodBeat.i(263306);
        float Y = Y(f2) + ((f3 - ((float) this.UCs)) * this.UDd.UDO);
        AppMethodBeat.o(263306);
        return Y;
    }

    private float aQ(float f2, float f3) {
        AppMethodBeat.i(263307);
        float Z = Z(f2) + ((f3 - ((float) this.UCt)) * this.UDd.UDP);
        AppMethodBeat.o(263307);
        return Z;
    }

    private final void d(Rect rect, RectF rectF) {
        AppMethodBeat.i(263308);
        rectF.left = Y((float) rect.left);
        rectF.right = Y((float) rect.right);
        rectF.top = Z((float) rect.top);
        rectF.bottom = Z((float) rect.bottom);
        AppMethodBeat.o(263308);
    }

    private final void D(Canvas canvas) {
        AppMethodBeat.i(263309);
        if (!this.aXs) {
            AppMethodBeat.o(263309);
        } else if (this.UCA == null || this.aXO == null) {
            AppMethodBeat.o(263309);
        } else {
            RectF rectF = this.UCA;
            if (rectF == null) {
                kotlin.g.b.p.hyc();
            }
            if (this.iY == null) {
                Paint paint = new Paint();
                paint.setColor(-1);
                paint.setStyle(Paint.Style.STROKE);
                this.iY = paint;
            }
            if (this.UCE) {
                StarryNight starryNight = this;
                float width = rectF.width() / ((float) starryNight.srcWidth);
                if (width >= 30.0f) {
                    PointF pointF = starryNight.aXO;
                    if (pointF == null) {
                        kotlin.g.b.p.hyc();
                    }
                    float f2 = pointF.x;
                    while (f2 <= rectF.right && f2 <= ((float) starryNight.getWidth())) {
                        float height = (float) starryNight.getHeight();
                        Paint paint2 = starryNight.iY;
                        if (paint2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        canvas.drawLine(f2, 0.0f, f2, height, paint2);
                        f2 += width;
                    }
                }
                StarryNight starryNight2 = this;
                float height2 = rectF.height() / ((float) starryNight2.srcHeight);
                if (height2 >= 30.0f) {
                    PointF pointF2 = starryNight2.aXO;
                    if (pointF2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    float f3 = pointF2.y;
                    while (f3 <= rectF.bottom && f3 <= ((float) starryNight2.getHeight())) {
                        float width2 = (float) starryNight2.getWidth();
                        Paint paint3 = starryNight2.iY;
                        if (paint3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        canvas.drawLine(0.0f, f3, width2, f3, paint3);
                        f3 += height2;
                    }
                }
            }
            AppMethodBeat.o(263309);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001cH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStar;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$DelayedAnimation;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "position", "Landroid/graphics/Point;", "config", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;Landroid/graphics/Point;Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "maxRadius", "", "getMaxRadius", "()F", "setMaxRadius", "(F)V", "minRadius", "getMinRadius", "setMinRadius", "paint", "Landroid/graphics/Paint;", "getPosition", "()Landroid/graphics/Point;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onStart", "plugin-festival_release"})
    public final class q extends c {
        final Point ApS;
        final /* synthetic */ StarryNight UDs;
        float UEa;
        final r UEb;
        int color;
        final Paint paint = new Paint();
        float yKF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(StarryNight starryNight, Point point, r rVar) {
            super(starryNight, starryNight, rVar);
            kotlin.g.b.p.h(point, "position");
            kotlin.g.b.p.h(rVar, "config");
            this.UDs = starryNight;
            AppMethodBeat.i(263272);
            this.ApS = point;
            this.UEb = rVar;
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            this.color = StarryNight.f(starryNight);
            this.UEa = StarryNight.a(starryNight, this.UEb);
            this.yKF = 1.1f * this.UEa;
            float[] fArr = {0.0f, 1.0f};
            kotlin.g.b.p.h(fArr, "floats");
            this.animator.setFloatValues(Arrays.copyOf(fArr, 2));
            AppMethodBeat.o(263272);
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.c
        public final void onStart() {
            AppMethodBeat.i(263271);
            if (((double) this.UDs.UCH.nextFloat()) < 0.5d) {
                this.color = this.UDs.getShinyStarColors().get(this.UDs.UCH.nextInt(0, this.UDs.getShinyStarColors().size() - 1)).intValue();
            }
            AppMethodBeat.o(263271);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020)2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010.J\b\u0010/\u001a\u00020)H\u0016J\u0012\u00100\u001a\u00020)2\n\u00101\u001a\u000202\"\u00020\nJ\u0012\u00103\u001a\u00020)2\n\u00104\u001a\u000205\"\u00020\u0010J\u0006\u00106\u001a\u00020)J\u0006\u00107\u001a\u00020)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001a\u0010$\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010'¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$DelayedAnimation;", "", "view", "Landroid/view/View;", "animConfig", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;Landroid/view/View;Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;)V", "getAnimConfig", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "animatedFraction", "", "getAnimatedFraction", "()F", "animatedValueFloat", "getAnimatedValueFloat", "animatedValueInt", "", "getAnimatedValueInt", "()I", "animationDelayMs", "", "getAnimationDelayMs", "()J", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "durationMs", "getDurationMs", "<set-?>", "", "isRunning", "()Z", "isStarted", "repeat", "getRepeat", "setRepeat", "(Z)V", "addListener", "", "l", "Landroid/animation/Animator$AnimatorListener;", "addOnEnd", "cb", "Lkotlin/Function0;", "onStart", "setFloatValue", "floats", "", "setIntValue", "ints", "", "start", "stop", "plugin-festival_release"})
    public class c {
        final a UDr;
        final /* synthetic */ StarryNight UDs;
        ValueAnimator animator = new ValueAnimator();
        boolean dqT = true;
        boolean isRunning;
        boolean isStarted;

        public c(StarryNight starryNight, final View view, a aVar) {
            kotlin.g.b.p.h(view, "view");
            this.UDs = starryNight;
            AppMethodBeat.i(263244);
            this.UDr = aVar;
            this.animator.setInterpolator(new LinearInterpolator());
            this.animator.addListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.festival.ui.StarryNight.c.AnonymousClass1 */
                final /* synthetic */ c UDt;

                {
                    this.UDt = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(263236);
                    this.UDt.isRunning = true;
                    this.UDt.onStart();
                    AppMethodBeat.o(263236);
                }

                public final void onAnimationEnd(Animator animator) {
                    long j2;
                    AppMethodBeat.i(263237);
                    this.UDt.isRunning = false;
                    if (!this.UDt.isStarted || !this.UDt.dqT) {
                        AppMethodBeat.o(263237);
                        return;
                    }
                    View view = view;
                    a aVar = new a(this, animator);
                    c cVar = this.UDt;
                    a aVar2 = cVar.UDr;
                    if (aVar2 != null) {
                        j2 = (long) StarryNight.a(cVar.UDs, aVar2);
                    } else {
                        j2 = 0;
                    }
                    view.postDelayed(aVar, j2);
                    AppMethodBeat.o(263237);
                }

                @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
                /* renamed from: com.tencent.mm.plugin.festival.ui.StarryNight$c$1$a */
                static final class a implements Runnable {
                    final /* synthetic */ AnonymousClass1 UDu;
                    final /* synthetic */ Animator UDv;

                    a(AnonymousClass1 r1, Animator animator) {
                        this.UDu = r1;
                        this.UDv = animator;
                    }

                    public final void run() {
                        AppMethodBeat.i(263235);
                        if (this.UDu.UDt.isStarted && this.UDu.UDt.dqT) {
                            Animator animator = this.UDv;
                            if (animator != null) {
                                animator.setDuration(this.UDu.UDt.getDurationMs());
                            }
                            Animator animator2 = this.UDv;
                            if (animator2 != null) {
                                animator2.start();
                                AppMethodBeat.o(263235);
                                return;
                            }
                        }
                        AppMethodBeat.o(263235);
                    }
                }
            });
            AppMethodBeat.o(263244);
        }

        public final long getDurationMs() {
            AppMethodBeat.i(263239);
            a aVar = this.UDr;
            if (aVar != null) {
                long b2 = (long) StarryNight.b(this.UDs, aVar);
                AppMethodBeat.o(263239);
                return b2;
            }
            AppMethodBeat.o(263239);
            return 0;
        }

        public final void ac(int... iArr) {
            AppMethodBeat.i(263240);
            kotlin.g.b.p.h(iArr, "ints");
            this.animator.setIntValues(Arrays.copyOf(iArr, 2));
            AppMethodBeat.o(263240);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/ui/StarryNight$DelayedAnimation$addOnEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
        public static final class a implements Animator.AnimatorListener {
            final /* synthetic */ kotlin.g.a.a cPy;

            a(kotlin.g.a.a aVar) {
                this.cPy = aVar;
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(263238);
                if (this.cPy != null) {
                    this.cPy.invoke();
                }
                AppMethodBeat.o(263238);
            }
        }

        public final void ay(kotlin.g.a.a<kotlin.x> aVar) {
            AppMethodBeat.i(263241);
            this.animator.addListener(new a(aVar));
            AppMethodBeat.o(263241);
        }

        public final void start() {
            AppMethodBeat.i(263242);
            if (this.isStarted) {
                AppMethodBeat.o(263242);
                return;
            }
            this.isStarted = true;
            this.animator.setDuration(getDurationMs());
            a aVar = this.UDr;
            int c2 = aVar != null ? StarryNight.c(this.UDs, aVar) : 0;
            if (c2 == 0) {
                this.animator.start();
                AppMethodBeat.o(263242);
                return;
            }
            this.animator.setStartDelay((long) c2);
            this.animator.start();
            AppMethodBeat.o(263242);
        }

        public void onStart() {
        }

        public final void stop() {
            AppMethodBeat.i(263243);
            if (!this.isStarted) {
                AppMethodBeat.o(263243);
                return;
            }
            this.isStarted = false;
            this.animator.end();
            AppMethodBeat.o(263243);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u001fH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStar;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$DelayedAnimation;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "position", "Landroid/graphics/PointF;", "animConfig", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStarAnimConfig;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;Landroid/graphics/PointF;Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStarAnimConfig;)V", "currentX", "", "getCurrentX", "()F", "setCurrentX", "(F)V", "currentY", "getCurrentY", "setCurrentY", "dst", "Landroid/graphics/RectF;", "ratio", "getRatio", "setRatio", "sensor", "", "getSensor", "()Z", "setSensor", "(Z)V", "src", "Landroid/graphics/Rect;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onStart", "plugin-festival_release"})
    public final class d extends c {
        final /* synthetic */ StarryNight UDs;
        boolean UDw;
        final Rect UDx;
        final RectF UDy;
        private final PointF UDz;
        float jJv = -1.0f;
        float jJw = -1.0f;
        float tEJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(StarryNight starryNight, PointF pointF, e eVar) {
            super(starryNight, starryNight, eVar);
            kotlin.g.b.p.h(eVar, "animConfig");
            this.UDs = starryNight;
            AppMethodBeat.i(263246);
            this.UDz = pointF;
            this.tEJ = eVar.tEJ;
            this.UDw = eVar.UDw;
            int[] iArr = new int[2];
            iArr[0] = 0;
            List<Bitmap> flashStarBitmap = starryNight.getFlashStarBitmap();
            if (flashStarBitmap == null) {
                kotlin.g.b.p.hyc();
            }
            iArr[1] = flashStarBitmap.size() - 1;
            ac(iArr);
            this.dqT = eVar.dqT;
            this.UDx = new Rect();
            this.UDy = new RectF();
            AppMethodBeat.o(263246);
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.c
        public final void onStart() {
            AppMethodBeat.i(263245);
            if (this.UDz != null) {
                this.jJv = (float) this.UDs.aZ(this.UDz.x);
                this.jJw = (float) this.UDs.cV(this.UDz.y);
                AppMethodBeat.o(263245);
                return;
            }
            int nextInt = this.UDs.UCH.nextInt(0, this.UDs.getSrcWidth());
            int nextInt2 = this.UDs.UCH.nextInt(0, this.UDs.getSrcHeight());
            this.jJv = (float) nextInt;
            this.jJw = (float) nextInt2;
            AppMethodBeat.o(263245);
        }
    }

    public final Paint getFlashStarPaint() {
        return this.UCY;
    }

    public final void setFlashStarPaint(Paint paint) {
        AppMethodBeat.i(263311);
        kotlin.g.b.p.h(paint, "<set-?>");
        this.UCY = paint;
        AppMethodBeat.o(263311);
    }

    private final void F(Canvas canvas) {
        List<Bitmap> flashStarBitmap;
        float Y;
        float Z;
        AppMethodBeat.i(263312);
        if (this.UCp != null) {
            List<Bitmap> list = this.UCp;
            if (list == null) {
                kotlin.g.b.p.hyc();
            }
            if (!list.isEmpty()) {
                if (this.UCZ == null) {
                    int i2 = this.UCq.rvw;
                    ArrayList arrayList = new ArrayList(i2);
                    for (int i3 = 0; i3 < i2; i3++) {
                        arrayList.add(new d(this, null, this.UCq));
                    }
                    this.UCZ = arrayList;
                    List<d> list2 = this.UCZ;
                    if (list2 != null) {
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().start();
                        }
                    }
                }
                List<d> list3 = this.UCZ;
                if (list3 != null) {
                    for (T t2 : list3) {
                        kotlin.g.b.p.h(canvas, "canvas");
                        if (t2.isRunning && t2.UDs.getDrawEffect() > 0 && (flashStarBitmap = t2.UDs.getFlashStarBitmap()) != null) {
                            Object animatedValue = t2.animator.getAnimatedValue();
                            if (animatedValue == null) {
                                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(263312);
                                throw tVar;
                            }
                            Bitmap bitmap = flashStarBitmap.get(((Integer) animatedValue).intValue());
                            if (t2.UDw) {
                                Y = t2.UDs.aP(t2.jJv, t2.UDs.getFlashStarSensorOffsetX());
                            } else {
                                Y = t2.UDs.Y(t2.jJv);
                            }
                            if (t2.UDw) {
                                Z = t2.UDs.aQ(t2.jJw, t2.UDs.getFlashStarSensorOffsetY());
                            } else {
                                Z = t2.UDs.Z(t2.jJw);
                            }
                            t2.UDx.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            float width = ((((float) bitmap.getWidth()) * t2.UDs.getScale()) * t2.tEJ) / 2.0f;
                            float height = ((((float) bitmap.getHeight()) * t2.UDs.getScale()) * t2.tEJ) / 2.0f;
                            t2.UDy.set(Y - width, Z - height, Y + width, Z + height);
                            canvas.drawBitmap(bitmap, t2.UDx, t2.UDy, t2.UDs.getFlashStarPaint());
                        }
                    }
                    AppMethodBeat.o(263312);
                    return;
                }
                AppMethodBeat.o(263312);
                return;
            }
        }
        AppMethodBeat.o(263312);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001eH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$Meteor;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$DelayedAnimation;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight;", "config", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$MeteorAnimConfig;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;Lcom/tencent/mm/plugin/festival/ui/StarryNight$MeteorAnimConfig;)V", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "matrix", "Landroid/graphics/Matrix;", "originX", "", "getOriginX", "()F", "setOriginX", "(F)V", "originY", "getOriginY", "setOriginY", "trackLengthX", "getTrackLengthX", "setTrackLengthX", "trackLengthY", "getTrackLengthY", "setTrackLengthY", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onStart", "plugin-festival_release"})
    public final class h extends c {
        float UDD;
        float UDE;
        float UDF;
        float UDG;
        final /* synthetic */ StarryNight UDs;
        final Matrix gT;
        int index;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(StarryNight starryNight, i iVar) {
            super(starryNight, starryNight, iVar);
            kotlin.g.b.p.h(iVar, "config");
            this.UDs = starryNight;
            AppMethodBeat.i(263249);
            this.dqT = iVar.dqT;
            int[] iArr = new int[2];
            iArr[0] = 0;
            List<List<Bitmap>> meteorBitmap = starryNight.getMeteorBitmap();
            if (meteorBitmap == null) {
                kotlin.g.b.p.hyc();
            }
            iArr[1] = meteorBitmap.get(0).size() - 1;
            ac(iArr);
            this.gT = new Matrix();
            AppMethodBeat.o(263249);
        }

        @Override // com.tencent.mm.plugin.festival.ui.StarryNight.c
        public final void onStart() {
            AppMethodBeat.i(263248);
            int nextInt = this.UDs.UCH.nextInt(this.UDs.getSrcWidth() / 2, (this.UDs.getSrcWidth() * 3) / 2);
            int nextInt2 = this.UDs.UCH.nextInt((-this.UDs.getSrcHeight()) / 2, this.UDs.getSrcHeight() / 3);
            this.UDD = this.UDs.Y((float) nextInt);
            this.UDE = this.UDs.Z((float) nextInt2);
            this.UDF = ((float) this.UDs.getSrcWidth()) * this.UDs.getScale();
            this.UDG = ((float) this.UDs.getSrcHeight()) * this.UDs.getScale();
            kotlin.j.c cVar = this.UDs.UCH;
            List<List<Bitmap>> meteorBitmap = this.UDs.getMeteorBitmap();
            if (meteorBitmap == null) {
                kotlin.g.b.p.hyc();
            }
            this.index = cVar.nextInt(meteorBitmap.size());
            AppMethodBeat.o(263248);
        }
    }

    public final Paint getMeteorPaint() {
        return this.UDa;
    }

    public final void setMeteorPaint(Paint paint) {
        AppMethodBeat.i(263313);
        kotlin.g.b.p.h(paint, "<set-?>");
        this.UDa = paint;
        AppMethodBeat.o(263313);
    }

    private void G(Canvas canvas) {
        AppMethodBeat.i(263314);
        kotlin.g.b.p.h(canvas, "canvas");
        if (this.UCm == null) {
            AppMethodBeat.o(263314);
            return;
        }
        if (this.UDb.isEmpty()) {
            h hVar = new h(this, this.UCn);
            this.UDb.add(hVar);
            hVar.start();
        }
        for (T t2 : this.UDb) {
            kotlin.g.b.p.h(canvas, "canvas");
            if (t2.isRunning) {
                List<List<Bitmap>> meteorBitmap = t2.UDs.getMeteorBitmap();
                if (meteorBitmap == null) {
                    kotlin.g.b.p.hyc();
                }
                List<Bitmap> list = meteorBitmap.get(t2.index);
                Object animatedValue = t2.animator.getAnimatedValue();
                if (animatedValue == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(263314);
                    throw tVar;
                }
                Bitmap bitmap = list.get(((Integer) animatedValue).intValue());
                float animatedFraction = t2.animator.getAnimatedFraction();
                t2.gT.reset();
                if (t2.UDs.getDrawEffect() == 1) {
                    float height = (t2.UDs.density * 10.0f) / ((float) bitmap.getHeight());
                    t2.gT.setScale(height, height);
                } else if (t2.UDs.getDrawEffect() == 2) {
                    float height2 = (t2.UDs.density * 3.5f) / ((float) bitmap.getHeight());
                    t2.gT.setScale(height2, height2);
                }
                t2.gT.postRotate(-45.0f);
                t2.gT.postTranslate(t2.UDD - (t2.UDF * animatedFraction), (animatedFraction * t2.UDG) + t2.UDE);
                canvas.drawBitmap(bitmap, t2.gT, t2.UDs.getMeteorPaint());
            }
        }
        AppMethodBeat.o(263314);
    }

    public final void hSj() {
        AppMethodBeat.i(263315);
        b.hSl();
        int nextInt = this.UCH.nextInt(3, 5);
        for (int i2 = 0; i2 < nextInt; i2++) {
            h hVar = new h(this, this.UCo);
            hVar.ay(new x(this, hVar));
            this.UDb.add(hVar);
            hVar.start();
        }
        AppMethodBeat.o(263315);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$Time;", "", "hour", "", "minutes", "seconds", "(III)V", "getHour", "()I", "getMinutes", "setMinutes", "(I)V", "getSeconds", "setSeconds", "plugin-festival_release"})
    public static final class u {
        int UEl = 0;
        int UEm = 0;
        final int hour;

        public u(int i2) {
            this.hour = i2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$LightNDarkLogic;", "", "()V", "animSeconds", "", "getAnimSeconds", "()I", "setAnimSeconds", "(I)V", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "darkStart", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$Time;", "getDarkStart", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$Time;", "setDarkStart", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight$Time;)V", "lightStart", "getLightStart", "setLightStart", "getCurrentMode", "", "timeOfNow", "plugin-festival_release"})
    public static final class f {
        u UDA = new u(6);
        int UDB = 8;
        u UDC = new u(18);
        final Calendar calendar = Calendar.getInstance();

        public f() {
            AppMethodBeat.i(263247);
            AppMethodBeat.o(263247);
        }
    }

    public final f getLightNDark() {
        return this.UDc;
    }

    public final void onResume() {
        AppMethodBeat.i(263316);
        b.hSl();
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "onResume");
        }
        this.UDd.hSn();
        List<d> list = this.UCZ;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
        List<q> list2 = this.UCX;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().start();
            }
        }
        Iterator<T> it3 = this.UDb.iterator();
        while (it3.hasNext()) {
            it3.next().start();
        }
        AppMethodBeat.o(263316);
    }

    public final void onPause() {
        ValueAnimator valueAnimator;
        AppMethodBeat.i(263317);
        b.hSl();
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "onPause");
        }
        this.UDd.hSo();
        List<d> list = this.UCZ;
        if (list != null) {
            for (d dVar : new ArrayList(list)) {
                dVar.stop();
            }
        }
        List<q> list2 = this.UCX;
        if (list2 != null) {
            for (q qVar : new ArrayList(list2)) {
                qVar.stop();
            }
        }
        for (h hVar : new ArrayList(this.UDb)) {
            hVar.stop();
        }
        s sVar = this.UCS;
        if (sVar == null || (valueAnimator = sVar.animator) == null) {
            AppMethodBeat.o(263317);
            return;
        }
        valueAnimator.cancel();
        AppMethodBeat.o(263317);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001a\u0010\u001e\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020\u001cJ\b\u0010%\u001a\u00020\u001cH\u0002J\u0006\u0010&\u001a\u00020\u001cJ\b\u0010'\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$Sensor;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;Landroid/content/Context;)V", "developerAllow", "", "deviceRunning", "<set-?>", "isResume", "()Z", "manager", "Landroid/hardware/SensorManager;", "sensor", "Landroid/hardware/Sensor;", "kotlin.jvm.PlatformType", "sensorInterpreter", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$SensorInterpreter;", "sensorRatioX", "", "getSensorRatioX", "()F", "setSensorRatioX", "(F)V", "sensorRatioY", "getSensorRatioY", "setSensorRatioY", "devicePause", "", "deviceResume", "onAccuracyChanged", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "pause", "pauseIfNeeded", "resume", "resumeIfNeeded", "plugin-festival_release"})
    public final class o implements SensorEventListener {
        private final p UDN;
        float UDO;
        float UDP;
        private boolean UDQ;
        public boolean UDR;
        final /* synthetic */ StarryNight UDs;
        private boolean isResume;
        private final SensorManager manager;
        private final Sensor sensor;

        public o(StarryNight starryNight, Context context) {
            kotlin.g.b.p.h(context, "context");
            this.UDs = starryNight;
            AppMethodBeat.i(263268);
            Object systemService = context.getSystemService("sensor");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.hardware.SensorManager");
                AppMethodBeat.o(263268);
                throw tVar;
            }
            this.manager = (SensorManager) systemService;
            this.sensor = this.manager.getDefaultSensor(11);
            this.UDN = new p();
            this.UDR = true;
            AppMethodBeat.o(263268);
        }

        public final void hSn() {
            AppMethodBeat.i(263262);
            this.UDQ = true;
            hSp();
            AppMethodBeat.o(263262);
        }

        public final void hSo() {
            AppMethodBeat.i(263263);
            this.UDQ = false;
            hSq();
            AppMethodBeat.o(263263);
        }

        public final void pause() {
            AppMethodBeat.i(263264);
            this.UDR = false;
            hSq();
            AppMethodBeat.o(263264);
        }

        public final void hSp() {
            AppMethodBeat.i(263265);
            if (this.isResume) {
                AppMethodBeat.o(263265);
                return;
            }
            if (this.UDR && this.UDQ) {
                this.isResume = true;
                this.manager.registerListener(this, this.sensor, 2);
            }
            AppMethodBeat.o(263265);
        }

        private final void hSq() {
            AppMethodBeat.i(263266);
            this.isResume = false;
            this.manager.unregisterListener(this);
            AppMethodBeat.o(263266);
        }

        public final void onAccuracyChanged(Sensor sensor2, int i2) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr;
            float[] fArr2;
            AppMethodBeat.i(263267);
            kotlin.g.b.p.h(sensorEvent, "event");
            p pVar = this.UDN;
            Context context = this.UDs.getContext();
            kotlin.g.b.p.g(context, "context");
            kotlin.g.b.p.h(context, "context");
            if (sensorEvent == null) {
                fArr2 = null;
            } else {
                kotlin.g.b.p.h(sensorEvent, "event");
                if (sensorEvent.values.length > 4) {
                    if (pVar.UDX == null) {
                        pVar.UDX = new float[4];
                    }
                    float[] fArr3 = sensorEvent.values;
                    float[] fArr4 = pVar.UDX;
                    if (fArr4 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    System.arraycopy(fArr3, 0, fArr4, 0, 4);
                    fArr = pVar.UDX;
                    if (fArr == null) {
                        kotlin.g.b.p.hyc();
                    }
                } else {
                    fArr = sensorEvent.values;
                    kotlin.g.b.p.g(fArr, "event.values");
                }
                if (!pVar.UDT) {
                    SensorManager.getRotationMatrixFromVector(pVar.UDU, fArr);
                    pVar.UDT = true;
                    fArr2 = null;
                } else {
                    SensorManager.getRotationMatrixFromVector(pVar.UDV, fArr);
                    Object systemService = context.getSystemService("window");
                    if (systemService == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
                        AppMethodBeat.o(263267);
                        throw tVar;
                    }
                    Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                    kotlin.g.b.p.g(defaultDisplay, "(context\n               …          .defaultDisplay");
                    int rotation = defaultDisplay.getRotation();
                    if (rotation == 0) {
                        SensorManager.getAngleChange(pVar.UDS, pVar.UDV, pVar.UDU);
                    } else {
                        switch (rotation) {
                            case 1:
                                SensorManager.remapCoordinateSystem(pVar.UDV, 2, 129, pVar.UDW);
                                break;
                            case 2:
                                SensorManager.remapCoordinateSystem(pVar.UDV, 129, 130, pVar.UDW);
                                break;
                            case 3:
                                SensorManager.remapCoordinateSystem(pVar.UDV, 130, 1, pVar.UDW);
                                break;
                        }
                        SensorManager.getAngleChange(pVar.UDS, pVar.UDW, pVar.UDU);
                    }
                    int length = pVar.UDS.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        float[] fArr5 = pVar.UDS;
                        fArr5[i2] = fArr5[i2] / 3.1415927f;
                        float[] fArr6 = pVar.UDS;
                        fArr6[i2] = fArr6[i2] * pVar.UDY;
                        if (pVar.UDS[i2] > 1.0f) {
                            pVar.UDS[i2] = 1.0f;
                        } else if (pVar.UDS[i2] < -1.0f) {
                            pVar.UDS[i2] = -1.0f;
                        }
                    }
                    fArr2 = pVar.UDS;
                }
            }
            if (fArr2 == null) {
                AppMethodBeat.o(263267);
                return;
            }
            this.UDO = fArr2[2];
            this.UDP = -fArr2[1];
            AppMethodBeat.o(263267);
        }
    }

    public final o getSensor() {
        return this.UDd;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "", "animCount", "", "durationMinMs", "durationMaxMs", "delayMinMs", "delayMaxMs", "(IIIII)V", "getAnimCount", "()I", "getDelayMaxMs", "getDelayMinMs", "getDurationMaxMs", "getDurationMinMs", "startDelayMs", "Lkotlin/ranges/IntRange;", "getStartDelayMs", "()Lkotlin/ranges/IntRange;", "setStartDelayMs", "(Lkotlin/ranges/IntRange;)V", "plugin-festival_release"})
    public static class a {
        kotlin.k.f UDm;
        final int UDn = 2000;
        final int UDo;
        final int UDp;
        final int UDq;
        final int rvw;

        public a(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(263231);
            this.rvw = i2;
            this.UDo = i3;
            this.UDp = i4;
            this.UDq = i5;
            this.UDm = new kotlin.k.f(0, 0);
            AppMethodBeat.o(263231);
        }

        public final void a(kotlin.k.f fVar) {
            AppMethodBeat.i(263230);
            kotlin.g.b.p.h(fVar, "<set-?>");
            this.UDm = fVar;
            AppMethodBeat.o(263230);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$FlashStarAnimConfig;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "animCount", "", "durationMinMs", "durationMaxMs", "delayMinMs", "delayMaxMs", "(IIIII)V", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "repeat", "", "getRepeat", "()Z", "setRepeat", "(Z)V", "sensor", "getSensor", "setSensor", "plugin-festival_release"})
    public static final class e extends a {
        boolean UDw = true;
        boolean dqT = true;
        float tEJ = 1.0f;

        public e(int i2, int i3) {
            super(i2, 2000, 0, i3);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$ShinyStarConfig;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "sensorOffsetX", "", "sensorOffsetY", "radiusMin", "radiusMax", "alphaMin", "alphaMax", "animCount", "", "durationMinMs", "durationMaxMs", "delayMinMs", "delayMaxMs", "(FFFFFFIIIII)V", "getAlphaMax", "()F", "getAlphaMin", "getRadiusMax", "getRadiusMin", "getSensorOffsetX", "getSensorOffsetY", "plugin-festival_release"})
    public static final class r extends a {
        final float UEc;
        final float UEd;
        final float UEe;
        final float UEf;
        private final float UEg;
        private final float UEh;

        public r(float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
            super(i2, 6000, 1000, 3000);
            this.UEc = f2;
            this.UEd = f3;
            this.UEe = f4;
            this.UEf = f5;
            this.UEg = f6;
            this.UEh = f7;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$MeteorAnimConfig;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$AnimConfig;", "repeat", "", "durationMinMs", "", "durationMaxMs", "delayMinMs", "delayMaxMs", "(ZIIII)V", "animCountRange", "Lkotlin/ranges/IntRange;", "getAnimCountRange", "()Lkotlin/ranges/IntRange;", "setAnimCountRange", "(Lkotlin/ranges/IntRange;)V", "getRepeat", "()Z", "plugin-festival_release"})
    public static final class i extends a {
        private kotlin.k.f UDH = new kotlin.k.f(0, 1);
        final boolean dqT;

        public i(boolean z, int i2, int i3) {
            super(1, 2000, i2, i3);
            AppMethodBeat.i(263251);
            this.dqT = z;
            AppMethodBeat.o(263251);
        }

        public final void b(kotlin.k.f fVar) {
            AppMethodBeat.i(263250);
            kotlin.g.b.p.h(fVar, "<set-?>");
            this.UDH = fVar;
            AppMethodBeat.o(263250);
        }
    }

    private final int getRandomColor$2b5cca86() {
        AppMethodBeat.i(263318);
        int intValue = this.UCx.get(this.UCH.nextInt(0, this.UCx.size() - 1)).intValue();
        AppMethodBeat.o(263318);
        return intValue;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "getInterpolation"})
    static final class v implements TimeInterpolator {
        public static final v UEn = new v();

        static {
            AppMethodBeat.i(263276);
            AppMethodBeat.o(263276);
        }

        v() {
        }

        public final float getInterpolation(float f2) {
            AppMethodBeat.i(263275);
            float pow = (float) (1.0d - Math.pow(1.0d - ((double) f2), 2.0d));
            AppMethodBeat.o(263275);
            return pow;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "getInterpolation"})
    static final class y implements TimeInterpolator {
        public static final y UEt = new y();

        static {
            AppMethodBeat.i(263292);
            AppMethodBeat.o(263292);
        }

        y() {
        }

        public final float getInterpolation(float f2) {
            AppMethodBeat.i(263291);
            float pow = (float) (1.0d - Math.pow(1.0d - ((double) f2), 2.0d));
            AppMethodBeat.o(263291);
            return pow;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0002\u0000\u0003\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, hxF = {"com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "springBackListener", "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1$springBackListener$1", "getSpringBackListener", "()Lcom/tencent/mm/plugin/festival/ui/StarryNight$gesture$1$springBackListener$1;", "Lcom/tencent/mm/plugin/festival/ui/StarryNight$gesture$1$springBackListener$1;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "", "onScroll", "down", "move", "x", "y", "onSingleTapUp", "plugin-festival_release"})
    public static final class w extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ StarryNight UDs;
        private final a UEo = new a(this);

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(263288);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(263288);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(263287);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(263287);
            return onDoubleTap;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        w(StarryNight starryNight) {
            this.UDs = starryNight;
            AppMethodBeat.i(263286);
            AppMethodBeat.o(263286);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            j onCanvasClickListener;
            AppMethodBeat.i(263281);
            kotlin.g.b.p.h(motionEvent, "down");
            kotlin.g.b.p.h(motionEvent2, "move");
            if (!this.UDs.CJo && (onCanvasClickListener = this.UDs.getOnCanvasClickListener()) != null) {
                onCanvasClickListener.onTouchEvent(motionEvent);
            }
            j onCanvasClickListener2 = this.UDs.getOnCanvasClickListener();
            if (onCanvasClickListener2 != null) {
                onCanvasClickListener2.onTouchEvent(motionEvent2);
            }
            this.UDs.CJo = true;
            if (!this.UDs.getDraggable() || this.UDs.aXO == null || this.UDs.isAnimating()) {
                AppMethodBeat.o(263281);
                return false;
            }
            this.UDs.UDe = true;
            float f4 = -f2;
            PointF pointF = this.UDs.aXO;
            if (pointF == null) {
                kotlin.g.b.p.hyc();
            }
            float f5 = pointF.x + f4;
            if (f5 < ((float) this.UDs.getWidth()) - (((float) this.UDs.getSrcWidth()) * this.UDs.getScale())) {
                if (f4 < 0.0f) {
                    PointF pointF2 = this.UDs.aXO;
                    if (pointF2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    f5 = pointF2.x + (f4 / 2.0f);
                }
            } else if (f5 > 0.0f && f4 > 0.0f) {
                PointF pointF3 = this.UDs.aXO;
                if (pointF3 == null) {
                    kotlin.g.b.p.hyc();
                }
                f5 = pointF3.x + (f4 / 2.0f);
            }
            PointF pointF4 = this.UDs.aXO;
            if (pointF4 == null) {
                kotlin.g.b.p.hyc();
            }
            pointF4.x = f5;
            AppMethodBeat.o(263281);
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(263282);
            kotlin.g.b.p.h(motionEvent, "e1");
            kotlin.g.b.p.h(motionEvent2, "e2");
            g logger = this.UDs.getLogger();
            if (logger != null) {
                logger.i("StarryNight", "onFling " + this.UDs.getDraggable() + ' ' + this.UDs.aXO + ' ' + this.UDs.isAnimating());
            }
            this.UDs.JUj = true;
            this.UDs.CJo = false;
            if (!this.UDs.getDraggable() || this.UDs.aXO == null || this.UDs.isAnimating()) {
                AppMethodBeat.o(263282);
                return false;
            }
            float width = ((float) this.UDs.getWidth()) - (((float) this.UDs.getSrcWidth()) * this.UDs.getScale());
            PointF pointF = this.UDs.aXO;
            if (pointF == null) {
                kotlin.g.b.p.hyc();
            }
            float f4 = pointF.x;
            if (f4 < width || f4 > 0.0f) {
                g logger2 = this.UDs.getLogger();
                if (logger2 != null) {
                    StringBuilder append = new StringBuilder("onFling: SprintBack?yes ").append(width).append(' ').append(0.0f).append(' ');
                    PointF pointF2 = this.UDs.aXO;
                    if (pointF2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    logger2.i("StarryNight", append.append(pointF2.x).toString());
                }
                this.UDs.UDe = true;
                AppMethodBeat.o(263282);
                return true;
            }
            g logger3 = this.UDs.getLogger();
            if (logger3 != null) {
                StringBuilder append2 = new StringBuilder("onFling: SprintBack?no ").append(width).append(' ').append(0.0f).append(' ');
                PointF pointF3 = this.UDs.aXO;
                if (pointF3 == null) {
                    kotlin.g.b.p.hyc();
                }
                logger3.i("StarryNight", append2.append(pointF3.x).toString());
            }
            PointF pointF4 = this.UDs.aXO;
            if (pointF4 == null) {
                kotlin.g.b.p.hyc();
            }
            float flingRatio = pointF4.x + (this.UDs.getFlingRatio() * f2);
            if (flingRatio < width) {
                if (f2 < 0.0f) {
                    flingRatio = width - (this.UDs.density * 30.0f);
                }
            } else if (flingRatio > 0.0f && f2 > 0.0f) {
                flingRatio = (this.UDs.density * 30.0f) + 0.0f;
            }
            m mVar = new m();
            mVar.UDM = null;
            PointF pointF5 = new PointF();
            pointF5.x = flingRatio;
            pointF5.y = pointF4.y;
            mVar.aXO = pointF5;
            ValueAnimator hSm = mVar.hSm();
            hSm.setInterpolator(this.UDs.UDf);
            hSm.addListener(this.UEo);
            this.UDs.setScaleAndTranslate(mVar);
            AppMethodBeat.o(263282);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1$springBackListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
        public static final class a implements Animator.AnimatorListener {
            final /* synthetic */ w UEp;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(w wVar) {
                this.UEp = wVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(263279);
                kotlin.g.b.p.h(animator, "animation");
                g logger = this.UEp.UDs.getLogger();
                if (logger != null) {
                    logger.i("StarryNight", "onAnimationEnd: springBack");
                }
                this.UEp.UDs.post(new b(this));
                AppMethodBeat.o(263279);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class b implements Runnable {
                final /* synthetic */ a UEq;

                b(a aVar) {
                    this.UEq = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(263278);
                    this.UEq.UEp.UDs.hSk();
                    AppMethodBeat.o(263278);
                }
            }

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(263280);
                g logger = this.UEp.UDs.getLogger();
                if (logger != null) {
                    logger.i("StarryNight", "onAnimationCancel: springBack");
                }
                this.UEp.UDs.post(new RunnableC1071a(this));
                AppMethodBeat.o(263280);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.festival.ui.StarryNight$w$a$a  reason: collision with other inner class name */
            static final class RunnableC1071a implements Runnable {
                final /* synthetic */ a UEq;

                RunnableC1071a(a aVar) {
                    this.UEq = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(263277);
                    this.UEq.UEp.UDs.hSk();
                    AppMethodBeat.o(263277);
                }
            }

            public final void onAnimationStart(Animator animator) {
            }
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(263283);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            kotlin.g.b.p.h(motionEvent, "e");
            g logger = this.UDs.getLogger();
            if (logger != null) {
                logger.i("StarryNight", e.a.NAME);
            }
            if (this.UDs.getDebug()) {
                if (!this.UDs.getDebugWish()) {
                    m mVar = new m();
                    mVar.UDM = Float.valueOf((((float) this.UDs.getHeight()) / ((float) this.UDs.getSrcHeight())) * 40.0f);
                    mVar.aXO = new PointF(0.0f, 0.0f);
                    mVar.hSm();
                    this.UDs.setScaleAndTranslate(mVar);
                    this.UDs.setDebugWish(true);
                } else {
                    this.UDs.setDebugWish(false);
                    StarryNight starryNight = this.UDs;
                    m mVar2 = new m();
                    mVar2.UDM = Float.valueOf(this.UDs.getVScaleDefault());
                    RectF vRectDefault = this.UDs.getVRectDefault();
                    mVar2.a(new Point(0, 0), new PointF(vRectDefault.left, vRectDefault.top));
                    starryNight.setScaleAndTranslate(mVar2);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(263283);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(263284);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            kotlin.g.b.p.h(motionEvent, "e");
            RectF vRect = this.UDs.getVRect();
            if (vRect == null) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(263284);
                return false;
            }
            int aZ = this.UDs.aZ(motionEvent.getX());
            int cV = this.UDs.cV(motionEvent.getY());
            if (vRect.contains(motionEvent.getX(), motionEvent.getY())) {
                j onCanvasClickListener = this.UDs.getOnCanvasClickListener();
                if (onCanvasClickListener == null || !onCanvasClickListener.kM(aZ, cV)) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(263284);
                    return false;
                }
                this.UDs.UCK.add(new l(motionEvent.getX(), motionEvent.getY()));
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(263284);
                return true;
            }
            j onCanvasClickListener2 = this.UDs.getOnCanvasClickListener();
            if (onCanvasClickListener2 != null) {
                onCanvasClickListener2.aM(motionEvent.getX(), motionEvent.getY());
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/festival/ui/StarryNight$gesture$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(263284);
            return false;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(263285);
            kotlin.g.b.p.h(motionEvent, "e");
            AppMethodBeat.o(263285);
            return true;
        }
    }

    public final void hSk() {
        float f2;
        AppMethodBeat.i(263319);
        if (this.aXO == null) {
            AppMethodBeat.o(263319);
            return;
        }
        PointF pointF = this.aXO;
        if (pointF == null) {
            kotlin.g.b.p.hyc();
        }
        float f3 = pointF.x;
        float width = ((float) getWidth()) - (((float) this.srcWidth) * this.scale);
        if (f3 < width) {
            f2 = width;
        } else if (f3 > 0.0f) {
            f2 = 0.0f;
        } else {
            AppMethodBeat.o(263319);
            return;
        }
        g gVar = this.UCc;
        if (gVar != null) {
            gVar.i("StarryNight", "springBack " + f2 + ' ' + f3 + ' ' + width + ' ' + 0.0f);
        }
        PointF pointF2 = this.aXO;
        if (pointF2 == null) {
            kotlin.g.b.p.hyc();
        }
        float f4 = pointF2.y;
        m mVar = new m();
        mVar.UDM = null;
        mVar.aXO = new PointF(f2, f4);
        mVar.hSm().setInterpolator(this.UDg);
        setScaleAndTranslate(mVar);
        AppMethodBeat.o(263319);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        j jVar;
        AppMethodBeat.i(263320);
        kotlin.g.b.p.h(motionEvent, "event");
        if (motionEvent.getActionMasked() == 1) {
            this.UCF.set(motionEvent.getRawX(), motionEvent.getRawY());
        } else {
            PointF pointF = this.UCF;
            kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
            float hYV = kotlin.g.b.l.hYV();
            kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
            pointF.set(hYV, kotlin.g.b.l.hYV());
        }
        if (!this.UCd) {
            AppMethodBeat.o(263320);
            return false;
        }
        GestureDetector gestureDetector = this.ORf;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/festival/ui/StarryNight", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/festival/ui/StarryNight", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            g gVar = this.UCc;
            if (gVar != null) {
                gVar.i("StarryNight", "dl: touch up " + this.CJo + ' ' + this.JUj + ' ' + isAnimating());
            }
            if ((this.CJo || this.JUj) && (jVar = this.UCg) != null) {
                jVar.onTouchEvent(motionEvent);
            }
            if (this.UDe && !isAnimating()) {
                hSk();
            }
            this.CJo = false;
            this.JUj = false;
            this.UDe = false;
        }
        AppMethodBeat.o(263320);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslate;", "", "()V", "<set-?>", "Landroid/animation/ValueAnimator;", "animator", "getAnimator", "()Landroid/animation/ValueAnimator;", "scale", "", "getScale", "()Ljava/lang/Float;", "setScale", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "vTranslate", "Landroid/graphics/PointF;", "getVTranslate", "()Landroid/graphics/PointF;", "setVTranslate", "(Landroid/graphics/PointF;)V", "enableAnimator", "", "sPoint", "Landroid/graphics/Point;", "vPoint", "toString", "", "plugin-festival_release"})
    public static final class m {
        public Float UDM;
        PointF aXO;
        ValueAnimator animator;

        public final void a(Point point, PointF pointF) {
            AppMethodBeat.i(263257);
            kotlin.g.b.p.h(point, "sPoint");
            kotlin.g.b.p.h(pointF, "vPoint");
            if (this.UDM == null || this.aXO != null) {
                IllegalStateException illegalStateException = new IllegalStateException("not illegal");
                AppMethodBeat.o(263257);
                throw illegalStateException;
            }
            PointF pointF2 = new PointF();
            float f2 = pointF.x;
            float f3 = (float) point.x;
            Float f4 = this.UDM;
            if (f4 == null) {
                kotlin.g.b.p.hyc();
            }
            pointF2.x = f2 - (f3 * f4.floatValue());
            float f5 = pointF.y;
            float f6 = (float) point.y;
            Float f7 = this.UDM;
            if (f7 == null) {
                kotlin.g.b.p.hyc();
            }
            pointF2.y = f5 - (f6 * f7.floatValue());
            this.aXO = pointF2;
            AppMethodBeat.o(263257);
        }

        public final ValueAnimator hSm() {
            AppMethodBeat.i(263258);
            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator == null) {
                kotlin.g.b.p.hyc();
            }
            AppMethodBeat.o(263258);
            return valueAnimator;
        }

        public final String toString() {
            AppMethodBeat.i(263259);
            StringBuilder append = new StringBuilder("[").append(this.UDM).append(", ").append(this.aXO).append(", ");
            ValueAnimator valueAnimator = this.animator;
            String sb = append.append(valueAnimator != null ? valueAnimator.getDuration() : -1).append(']').toString();
            AppMethodBeat.o(263259);
            return sb;
        }
    }

    public final boolean isAnimating() {
        return this.UDh != null;
    }

    public final void setScaleAndTranslate(m mVar) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        AppMethodBeat.i(263321);
        if (!this.aXs || !this.UCE) {
            g gVar = this.UCc;
            if (gVar != null) {
                gVar.i("StarryNight", "setScaleAndTranslate ".concat(String.valueOf(mVar)));
            }
            if (this.UDh != null) {
                m mVar2 = this.UDh;
                if (!(mVar2 == null || (valueAnimator3 = mVar2.animator) == null)) {
                    valueAnimator3.cancel();
                }
                m mVar3 = this.UDh;
                if (!(mVar3 == null || (valueAnimator2 = mVar3.animator) == null)) {
                    valueAnimator2.removeListener(this.UDk);
                }
                m mVar4 = this.UDh;
                if (!(mVar4 == null || (valueAnimator = mVar4.animator) == null)) {
                    valueAnimator.removeUpdateListener(this.UDk);
                }
                this.UDh = null;
                this.UDj = null;
                this.UDh = null;
            }
            if (mVar == null) {
                AppMethodBeat.o(263321);
            } else if (mVar.animator == null || this.aXO == null) {
                Float f2 = mVar.UDM;
                PointF pointF = mVar.aXO;
                if (f2 != null) {
                    this.scale = f2.floatValue();
                }
                if (pointF != null) {
                    this.aXO = pointF;
                }
                invalidate();
                AppMethodBeat.o(263321);
            } else {
                ValueAnimator valueAnimator4 = mVar.animator;
                if (valueAnimator4 == null) {
                    kotlin.g.b.p.hyc();
                }
                valueAnimator4.addUpdateListener(this.UDk);
                valueAnimator4.addListener(this.UDk);
                this.UDi = Float.valueOf(this.scale);
                PointF pointF2 = this.aXO;
                if (pointF2 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f3 = pointF2.x;
                PointF pointF3 = this.aXO;
                if (pointF3 == null) {
                    kotlin.g.b.p.hyc();
                }
                this.UDj = new PointF(f3, pointF3.y);
                this.UDh = mVar;
                valueAnimator4.start();
                AppMethodBeat.o(263321);
            }
        } else {
            AppMethodBeat.o(263321);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$ScaleAndTranslateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "(Lcom/tencent/mm/plugin/festival/ui/StarryNight;)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "anim", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "plugin-festival_release"})
    public final class n implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public n() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z = true;
            AppMethodBeat.i(263260);
            kotlin.g.b.p.h(valueAnimator, LocaleUtil.ITALIAN);
            m mVar = StarryNight.this.UDh;
            if (mVar == null) {
                kotlin.g.b.p.hyc();
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(263260);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            boolean z2 = false;
            if (mVar.UDM != null) {
                StarryNight starryNight = StarryNight.this;
                Float f2 = mVar.UDM;
                if (f2 == null) {
                    kotlin.g.b.p.hyc();
                }
                float floatValue2 = f2.floatValue();
                Float f3 = StarryNight.this.UDi;
                if (f3 == null) {
                    kotlin.g.b.p.hyc();
                }
                float floatValue3 = (floatValue2 - f3.floatValue()) * floatValue;
                Float f4 = StarryNight.this.UDi;
                if (f4 == null) {
                    kotlin.g.b.p.hyc();
                }
                starryNight.scale = floatValue3 + f4.floatValue();
                z2 = true;
            }
            if (mVar.aXO == null) {
                z = z2;
            } else if (StarryNight.this.aXO == null) {
                AppMethodBeat.o(263260);
                return;
            } else {
                PointF pointF = StarryNight.this.aXO;
                if (pointF == null) {
                    kotlin.g.b.p.hyc();
                }
                PointF pointF2 = mVar.aXO;
                if (pointF2 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f5 = pointF2.x;
                PointF pointF3 = StarryNight.this.UDj;
                if (pointF3 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f6 = (f5 - pointF3.x) * floatValue;
                PointF pointF4 = StarryNight.this.UDj;
                if (pointF4 == null) {
                    kotlin.g.b.p.hyc();
                }
                pointF.x = f6 + pointF4.x;
                PointF pointF5 = StarryNight.this.aXO;
                if (pointF5 == null) {
                    kotlin.g.b.p.hyc();
                }
                PointF pointF6 = mVar.aXO;
                if (pointF6 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f7 = pointF6.y;
                PointF pointF7 = StarryNight.this.UDj;
                if (pointF7 == null) {
                    kotlin.g.b.p.hyc();
                }
                float f8 = (f7 - pointF7.y) * floatValue;
                PointF pointF8 = StarryNight.this.UDj;
                if (pointF8 == null) {
                    kotlin.g.b.p.hyc();
                }
                pointF5.y = f8 + pointF8.y;
            }
            if (z) {
                StarryNight.this.invalidate();
            }
            AppMethodBeat.o(263260);
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263261);
            kotlin.g.b.p.h(animator, "anim");
            m mVar = StarryNight.this.UDh;
            if (mVar == null) {
                kotlin.g.b.p.hyc();
            }
            ValueAnimator valueAnimator = mVar.animator;
            if (valueAnimator == null) {
                kotlin.g.b.p.hyc();
            }
            valueAnimator.removeListener(StarryNight.this.UDk);
            valueAnimator.removeUpdateListener(StarryNight.this.UDk);
            StarryNight.this.UDh = null;
            StarryNight.this.UDi = null;
            StarryNight.this.UDj = null;
            g logger = StarryNight.this.getLogger();
            if (logger != null) {
                logger.i("StarryNight", "SAT: onAnimationEnd");
                AppMethodBeat.o(263261);
                return;
            }
            AppMethodBeat.o(263261);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u00020\f*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$Companion;", "", "()V", "TAG", "", "blendARGB", "", "color1", "color2", "ratio", "", "checkUIThread", "", "pow2", "base", "sqrt", "x", "makeAlpha", "", "width", "height", "plugin-festival_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static void hSl() {
            AppMethodBeat.i(263232);
            if (!kotlin.g.b.p.j(Looper.myLooper(), Looper.getMainLooper())) {
                IllegalStateException illegalStateException = new IllegalStateException("Thread not ok");
                AppMethodBeat.o(263232);
                throw illegalStateException;
            }
            AppMethodBeat.o(263232);
        }

        static int h(int i2, int i3, float f2) {
            AppMethodBeat.i(263234);
            float f3 = 1.0f - f2;
            int argb = Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((f3 * ((float) Color.blue(i2))) + (((float) Color.blue(i3)) * f2)));
            AppMethodBeat.o(263234);
            return argb;
        }

        public static void i(int[] iArr, int i2, int i3) {
            int i4;
            AppMethodBeat.i(263233);
            kotlin.g.b.p.h(iArr, "$this$makeAlpha");
            int length = iArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = iArr[i5];
                int i8 = i6 + 1;
                int blue = Color.blue(i7);
                if (blue == 17 || blue == 0) {
                    iArr[i6] = 0;
                } else if (i6 < (i3 / 10) * i2 || i6 >= (i3 / 10) * 9 * i2) {
                    int i9 = i7 & 255;
                    if (i6 < (i3 / 10) * i2) {
                        i4 = (int) (((float) i9) * (((float) (i6 / i2)) / (((float) i3) / 10.0f)));
                    } else {
                        i4 = (int) (((float) i9) * (((float) (i3 - (i6 / i2))) / (((float) i3) / 10.0f)));
                    }
                    iArr[i6] = ((Math.max(Math.min(i4, 255), 0) & 255) << 24) | (i7 & 16777215);
                } else {
                    iArr[i6] = (i7 & 16777215) | WebView.NIGHT_MODE_COLOR;
                }
                i5++;
                i6 = i8;
            }
            AppMethodBeat.o(263233);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$SensorInterpreter;", "", "()V", "mOrientedRotationMatrix", "", "mRotationMatrix", "mTargetMatrix", "mTargeted", "", "mTiltSensitivity", "", "mTiltVector", "mTruncatedRotationVector", "tiltSensitivity", "getTiltSensitivity", "()F", "setTiltSensitivity", "(F)V", "getRotationVectorFromSensorEvent", "event", "Landroid/hardware/SensorEvent;", "interpretSensorEvent", "context", "Landroid/content/Context;", "reset", "", "setTargetVector", "values", "Companion", "plugin-festival_release"})
    static final class p {
        private static final String TAG;
        public static final a UDZ = new a((byte) 0);
        final float[] UDS = new float[3];
        boolean UDT;
        final float[] UDU = new float[16];
        final float[] UDV = new float[16];
        final float[] UDW = new float[16];
        float[] UDX;
        float UDY = 2.0f;

        public p() {
            AppMethodBeat.i(263269);
            AppMethodBeat.o(263269);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/StarryNight$SensorInterpreter$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(263270);
            String name = p.class.getName();
            kotlin.g.b.p.g(name, "SensorInterpreter::class.java.name");
            TAG = name;
            AppMethodBeat.o(263270);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/ui/StarryNight$startFlashStar$star$1$1"})
    public static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ StarryNight UDs;
        final /* synthetic */ d UEu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(d dVar, StarryNight starryNight) {
            super(0);
            this.UEu = dVar;
            this.UDs = starryNight;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(263294);
            this.UDs.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.festival.ui.StarryNight.z.AnonymousClass1 */
                final /* synthetic */ z UEv;

                {
                    this.UEv = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263293);
                    List list = this.UEv.UDs.UCZ;
                    if (list != null) {
                        list.remove(this.UEv.UEu);
                        AppMethodBeat.o(263293);
                        return;
                    }
                    AppMethodBeat.o(263293);
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(263294);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ StarryNight UDs;
        final /* synthetic */ h UEr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(StarryNight starryNight, h hVar) {
            super(0);
            this.UDs = starryNight;
            this.UEr = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(263290);
            this.UDs.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.festival.ui.StarryNight.x.AnonymousClass1 */
                final /* synthetic */ x UEs;

                {
                    this.UEs = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263289);
                    this.UEs.UDs.UDb.remove(this.UEs.UEr);
                    AppMethodBeat.o(263289);
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(263290);
            return xVar;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(android.graphics.Canvas r10) {
        /*
        // Method dump skipped, instructions count: 658
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.ui.StarryNight.onDraw(android.graphics.Canvas):void");
    }

    private final void E(Canvas canvas) {
        float f2;
        int h2;
        AppMethodBeat.i(263310);
        if (this.UCX == null) {
            this.UCX = new ArrayList();
            r[] rVarArr = this.UCw;
            for (r rVar : rVarArr) {
                int i2 = rVar.rvw;
                for (int i3 = 0; i3 < i2; i3++) {
                    q qVar = new q(this, new Point(this.UCH.nextInt(0, this.srcWidth), this.UCH.nextInt(0, this.srcHeight)), rVar);
                    List<q> list = this.UCX;
                    if (list != null) {
                        list.add(qVar);
                    }
                    qVar.start();
                }
            }
        }
        List<q> list2 = this.UCX;
        if (list2 != null) {
            for (T t2 : list2) {
                kotlin.g.b.p.h(canvas, "canvas");
                if (t2.isRunning) {
                    Object animatedValue = t2.animator.getAnimatedValue();
                    if (animatedValue == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                        AppMethodBeat.o(263310);
                        throw tVar;
                    }
                    float floatValue = ((Float) animatedValue).floatValue();
                    if (((double) floatValue) < 0.5d) {
                        f2 = t2.UEa + (2.0f * floatValue * (t2.yKF - t2.UEa));
                    } else {
                        f2 = t2.yKF - (((floatValue - 0.5f) * 2.0f) * (t2.yKF - t2.UEa));
                    }
                    if (((double) floatValue) < 0.5d) {
                        h2 = b.h(t2.color, -1, floatValue * 2.0f);
                    } else {
                        h2 = b.h(-1, t2.color, (floatValue - 0.5f) * 2.0f);
                    }
                    t2.paint.setStrokeWidth(f2);
                    t2.paint.setColor(h2);
                    canvas.drawPoint(t2.UDs.aP((float) t2.ApS.x, t2.UEb.UEc), t2.UDs.aQ((float) t2.ApS.y, t2.UEb.UEd), t2.paint);
                }
            }
            AppMethodBeat.o(263310);
            return;
        }
        AppMethodBeat.o(263310);
    }

    public static final /* synthetic */ int f(StarryNight starryNight) {
        AppMethodBeat.i(263328);
        int intValue = starryNight.UCx.get(starryNight.UCH.nextInt(0, starryNight.UCx.size() - 1)).intValue();
        AppMethodBeat.o(263328);
        return intValue;
    }

    public static final /* synthetic */ float a(StarryNight starryNight, r rVar) {
        AppMethodBeat.i(263329);
        if (rVar.UEe == rVar.UEf) {
            float f2 = rVar.UEe;
            AppMethodBeat.o(263329);
            return f2;
        }
        float nextFloat = (starryNight.UCH.nextFloat() * (rVar.UEf - rVar.UEe)) + rVar.UEe;
        AppMethodBeat.o(263329);
        return nextFloat;
    }

    public static final /* synthetic */ int a(StarryNight starryNight, a aVar) {
        AppMethodBeat.i(263330);
        if (aVar.UDp == aVar.UDq) {
            int i2 = aVar.UDp;
            AppMethodBeat.o(263330);
            return i2;
        }
        int nextInt = starryNight.UCH.nextInt(aVar.UDp, aVar.UDq + 1);
        AppMethodBeat.o(263330);
        return nextInt;
    }

    public static final /* synthetic */ int b(StarryNight starryNight, a aVar) {
        AppMethodBeat.i(263331);
        if (aVar.UDn == aVar.UDo) {
            int i2 = aVar.UDn;
            AppMethodBeat.o(263331);
            return i2;
        }
        int nextInt = starryNight.UCH.nextInt(aVar.UDn, aVar.UDo + 1);
        AppMethodBeat.o(263331);
        return nextInt;
    }

    public static final /* synthetic */ int c(StarryNight starryNight, a aVar) {
        AppMethodBeat.i(263332);
        if (aVar.UDm.SYU == aVar.UDm.SYV) {
            int i2 = aVar.UDm.SYU;
            AppMethodBeat.o(263332);
            return i2;
        }
        int a2 = kotlin.j.d.a(starryNight.UCH, aVar.UDm);
        AppMethodBeat.o(263332);
        return a2;
    }
}
