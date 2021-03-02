package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.r;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.sns.ui.SnsLabelUI;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.textstatus.PluginTextStatus;
import com.tencent.mm.plugin.textstatus.emoji.ImeEmojiView;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.view.MaxHeightScrollView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.g.b.z;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0017*\u0002RU\b\u0007\u0018\u0000 Ô\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Ô\u0002Õ\u0002B\u0005¢\u0006\u0002\u0010\u0005J\"\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020g0\u00022\u0010\u0010\u0002\u001a\u000b\u0012\u0004\u0012\u00020g\u0018\u00010\u0002H\u0002J\u0015\u0010\u0002\u001a\u00030\u00022\t\u0010\u0002\u001a\u0004\u0018\u00010gH\u0016J\u0015\u0010\u0002\u001a\u00030\u00022\t\u0010\u0002\u001a\u0004\u0018\u00010gH\u0016J\u0015\u0010\u0002\u001a\u00030\u00022\t\u0010\u0002\u001a\u0004\u0018\u00010gH\u0016J\n\u0010\u0002\u001a\u00030\u0002H\u0016J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0002\u001a\u000201H\u0002J\t\u0010\u0002\u001a\u000201H\u0014J\t\u0010\u0002\u001a\u000201H\u0014J\u000b\u0010\u0002\u001a\u0004\u0018\u00010gH\u0002J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0002\u001a\u000201H\u0002J\u0016\u0010\u0002\u001a\u00030\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0002J)\u0010\u0002\u001a\u00030\u00022\t\u0010 \u0002\u001a\u0004\u0018\u00010g2\t\u0010¡\u0002\u001a\u0004\u0018\u00010g2\u0007\u0010 \u0001\u001a\u000201H\u0002J\u001e\u0010¢\u0002\u001a\u00030\u00022\t\u0010£\u0002\u001a\u0004\u0018\u00010g2\u0007\u0010 \u0001\u001a\u000201H\u0002J(\u0010¤\u0002\u001a\u00030\u00022\u0007\u0010¥\u0002\u001a\u0002012\u0007\u0010¦\u0002\u001a\u0002012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0002J\n\u0010§\u0002\u001a\u00030\u0002H\u0002J\n\u0010¨\u0002\u001a\u00030\u0002H\u0002J\n\u0010©\u0002\u001a\u00030\u0002H\u0002J\n\u0010ª\u0002\u001a\u00030\u0002H\u0002J\n\u0010«\u0002\u001a\u00030\u0002H\u0002J\n\u0010¬\u0002\u001a\u00030\u0002H\u0002J \u0010­\u0002\u001a\t\u0012\u0004\u0012\u00020g0®\u00022\u000e\u0010¯\u0002\u001a\t\u0012\u0004\u0012\u00020g0\u0002H\u0002J(\u0010°\u0002\u001a\u00030\u00022\u0007\u0010¥\u0002\u001a\u0002012\u0007\u0010¦\u0002\u001a\u0002012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0014J\n\u0010±\u0002\u001a\u00030\u0002H\u0016J\u0016\u0010²\u0002\u001a\u00030\u00022\n\u0010³\u0002\u001a\u0005\u0018\u00010´\u0002H\u0017J\n\u0010µ\u0002\u001a\u00030\u0002H\u0016J\n\u0010¶\u0002\u001a\u00030\u0002H\u0014J\u001c\u0010·\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u0002012\u0007\u0010¸\u0002\u001a\u00020PH\u0016J\n\u0010¹\u0002\u001a\u00030\u0002H\u0014J\u0015\u0010º\u0002\u001a\u00030\u00022\t\u0010\u0002\u001a\u0004\u0018\u00010gH\u0016J5\u0010»\u0002\u001a\u00030\u00022\u0007\u0010¥\u0002\u001a\u0002012\u0010\u0010¼\u0002\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020g0½\u00022\b\u0010¾\u0002\u001a\u00030¿\u0002H\u0016¢\u0006\u0003\u0010À\u0002J\n\u0010Á\u0002\u001a\u00030\u0002H\u0014J\u0013\u0010Â\u0002\u001a\u00030\u00022\u0007\u0010Ã\u0002\u001a\u00020PH\u0016J\b\u0010Ä\u0002\u001a\u00030\u0002J\u0018\u0010Å\u0002\u001a\u00030\u00022\f\b\u0002\u0010Æ\u0002\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010Ç\u0002\u001a\u00030\u00022\t\u0010È\u0002\u001a\u0004\u0018\u00010gH\u0002J\u0013\u0010É\u0002\u001a\u00030\u00022\u0007\u0010Ê\u0002\u001a\u00020PH\u0002J\t\u0010Ë\u0002\u001a\u00020PH\u0002J\n\u0010Ì\u0002\u001a\u00030\u0002H\u0002J\n\u0010Í\u0002\u001a\u00030\u0002H\u0002J\u0014\u0010Î\u0002\u001a\u00030\u00022\b\u0010Ï\u0002\u001a\u00030¦\u0001H\u0002J\n\u0010Ð\u0002\u001a\u00030\u0002H\u0002J\n\u0010Ñ\u0002\u001a\u00030\u0002H\u0002J!\u0010Ò\u0002\u001a\u00030\u00022\n\u0010Æ\u0002\u001a\u0005\u0018\u00010\u00012\t\u0010Ó\u0002\u001a\u0004\u0018\u00010gH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u001a\u0010=\u001a\u00020>X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001b\u0010I\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bJ\u0010\u000eR\u001c\u0010L\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010\u0010R\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020RX\u0004¢\u0006\u0004\n\u0002\u0010SR\u0010\u0010T\u001a\u00020UX\u0004¢\u0006\u0004\n\u0002\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000e\"\u0004\bY\u0010\u0010R\u001c\u0010Z\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000e\"\u0004\b\\\u0010\u0010R\u001c\u0010]\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010\u0010R\u001c\u0010`\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u000e\"\u0004\bb\u0010\u0010R\u001c\u0010c\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000e\"\u0004\be\u0010\u0010R\u001c\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020mX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010n\u001a\u00020PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020sX.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001b\u0010x\u001a\u00020s8BX\u0002¢\u0006\f\n\u0004\bz\u0010<\u001a\u0004\by\u0010uR\u001b\u0010{\u001a\u00020|8BX\u0002¢\u0006\f\n\u0004\b\u0010<\u001a\u0004\b}\u0010~R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0001\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0005\n\u0003\u0010\u0001R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\fX.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u000e\"\u0005\b\u0001\u0010\u0010R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020gX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020gX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020gX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010 \u0001\u001a\u000201X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R \u0010¥\u0001\u001a\u00030¦\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u0012\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010­\u0001\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010i\"\u0005\b¯\u0001\u0010kR\u001f\u0010°\u0001\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010i\"\u0005\b²\u0001\u0010kR\"\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\"\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R\u0012\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u000e¢\u0006\u0002\n\u0000R \u0010Á\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\bÃ\u0001\u0010<\u001a\u0006\bÂ\u0001\u0010\u0001R\u001f\u0010Ä\u0001\u001a\u000201X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÅ\u0001\u0010¢\u0001\"\u0006\bÆ\u0001\u0010¤\u0001R\u000f\u0010Ç\u0001\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010È\u0001\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010i\"\u0005\bÊ\u0001\u0010kR\u001f\u0010Ë\u0001\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010i\"\u0005\bÍ\u0001\u0010kR \u0010Î\u0001\u001a\u00030Ï\u00018BX\u0002¢\u0006\u000f\n\u0005\bÒ\u0001\u0010<\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001e\u0010Ó\u0001\u001a\u00020|8BX\u0002¢\u0006\u000e\n\u0005\bÕ\u0001\u0010<\u001a\u0005\bÔ\u0001\u0010~R \u0010Ö\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\bØ\u0001\u0010<\u001a\u0006\b×\u0001\u0010\u0001R\u001f\u0010Ù\u0001\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010i\"\u0005\bÛ\u0001\u0010kR\u001e\u0010Ü\u0001\u001a\u00020\f8BX\u0002¢\u0006\u000e\n\u0005\bÞ\u0001\u0010<\u001a\u0005\bÝ\u0001\u0010\u000eR\u001f\u0010ß\u0001\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\u000e\"\u0005\bá\u0001\u0010\u0010R \u0010â\u0001\u001a\u0004\u0018\u00010|X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bã\u0001\u0010~\"\u0006\bä\u0001\u0010å\u0001R \u0010æ\u0001\u001a\u0004\u0018\u00010|X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bç\u0001\u0010~\"\u0006\bè\u0001\u0010å\u0001R \u0010é\u0001\u001a\u0004\u0018\u00010|X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bê\u0001\u0010~\"\u0006\bë\u0001\u0010å\u0001R \u0010ì\u0001\u001a\u0004\u0018\u00010|X\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bí\u0001\u0010~\"\u0006\bî\u0001\u0010å\u0001R\u0010\u0010ï\u0001\u001a\u00030ð\u0001X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010ñ\u0001\u001a\u00020sX.¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0001\u0010u\"\u0005\bó\u0001\u0010wR\u001e\u0010ô\u0001\u001a\u00020\f8BX\u0002¢\u0006\u000e\n\u0005\bö\u0001\u0010<\u001a\u0005\bõ\u0001\u0010\u000eR\u001e\u0010÷\u0001\u001a\u00020\f8BX\u0002¢\u0006\u000e\n\u0005\bù\u0001\u0010<\u001a\u0005\bø\u0001\u0010\u000eR\u001f\u0010ú\u0001\u001a\u0004\u0018\u00010sX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0001\u0010u\"\u0005\bü\u0001\u0010wR\u001e\u0010ý\u0001\u001a\u00020s8BX\u0002¢\u0006\u000e\n\u0005\bÿ\u0001\u0010<\u001a\u0005\bþ\u0001\u0010uR\u0011\u0010\u0002\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010\u000e\"\u0005\b\u0002\u0010\u0010R\u001f\u0010\u0002\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010\u000e\"\u0005\b\u0002\u0010\u0010R\u001f\u0010\u0002\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0002\u0010\u000e\"\u0005\b\u0002\u0010\u0010R\u000f\u0010\u0002\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020g0\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006Ö\u0002"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/textstatus/emoji/IKeyboardActionListener;", "()V", "animator_move_to_below", "Landroid/animation/ObjectAnimator;", "animator_move_to_up", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "setBtnBack", "(Landroid/view/View;)V", "btnEditFinish", "Landroid/widget/Button;", "getBtnEditFinish", "()Landroid/widget/Button;", "setBtnEditFinish", "(Landroid/widget/Button;)V", "btnOk", "getBtnOk", "setBtnOk", "btnTag", "getBtnTag", "setBtnTag", "cameraClickListener", "Landroid/view/View$OnClickListener;", "captureResult", "Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "getCaptureResult", "()Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "setCaptureResult", "(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "curlat", "", "getCurlat", "()F", "setCurlat", "(F)V", "curlng", "getCurlng", "setCurlng", "defaultBackgroundImgId", "", "editLayout", "getEditLayout", "setEditLayout", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "emojiContainer", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiView;", "getEmojiContainer", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiView;", "emojiContainer$delegate", "Lkotlin/Lazy;", "etDesc", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEtDesc", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEtDesc", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "etTextStatus", "Landroid/widget/EditText;", "getEtTextStatus", "()Landroid/widget/EditText;", "setEtTextStatus", "(Landroid/widget/EditText;)V", "fakeBtnOk", "getFakeBtnOk", "fakeBtnOk$delegate", "fakePic", "getFakePic", "setFakePic", "finishByPost", "", "globalLayoutListenerMode1", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1;", "globalLayoutListenerMode2", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1;", "iconCamera", "getIconCamera", "setIconCamera", "iconPoi", "getIconPoi", "setIconPoi", "iconStatus", "getIconStatus", "setIconStatus", "iconText", "getIconText", "setIconText", "iconVisibility", "getIconVisibility", "setIconVisibility", "imgResId", "", "getImgResId", "()Ljava/lang/String;", "setImgResId", "(Ljava/lang/String;)V", "imgVideoSource", "", "isBlur", "()Z", "setBlur", "(Z)V", "ivBlur", "Landroid/widget/ImageView;", "getIvBlur", "()Landroid/widget/ImageView;", "setIvBlur", "(Landroid/widget/ImageView;)V", "ivBlurSelect", "getIvBlurSelect", "ivBlurSelect$delegate", "ivBlurText", "Landroid/widget/TextView;", "getIvBlurText", "()Landroid/widget/TextView;", "ivBlurText$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyboardHeight", "Ljava/lang/Integer;", "lastOriBitmap", "Landroid/graphics/Bitmap;", "layoutBlurOption", "getLayoutBlurOption", "setLayoutBlurOption", "layoutEditDesc", "getLayoutEditDesc", "setLayoutEditDesc", "layoutEditToolContainer", "getLayoutEditToolContainer", "setLayoutEditToolContainer", "layoutShow", "getLayoutShow", "setLayoutShow", "layoutTopicEdit", "getLayoutTopicEdit", "setLayoutTopicEdit", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "locationClickListener", "mChatRoomNameList", "mLabelNameList", "mLabelRangeindex", "mOtherUserNameList", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "pageType", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "getPageType", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "setPageType", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;)V", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "poiId", "getPoiId", "setPoiId", "poiName", "getPoiName", "setPoiName", "scrollShow", "Lcom/tencent/mm/view/MaxHeightScrollView;", "getScrollShow", "()Lcom/tencent/mm/view/MaxHeightScrollView;", "setScrollShow", "(Lcom/tencent/mm/view/MaxHeightScrollView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getSetStatusParam", "()Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setSetStatusParam", "(Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "smileyRoot", "getSmileyRoot", "smileyRoot$delegate", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getStyle", "setStyle", "textClickListener", "textStatus", "getTextStatus", "setTextStatus", "textStatusTypeName", "getTextStatusTypeName", "setTextStatusTypeName", "thirdContainerLl", "Landroid/widget/LinearLayout;", "getThirdContainerLl", "()Landroid/widget/LinearLayout;", "thirdContainerLl$delegate", "thirdDescTv", "getThirdDescTv", "thirdDescTv$delegate", "thirdIconContainerFl", "getThirdIconContainerFl", "thirdIconContainerFl$delegate", "thirdThumbPath", "getThirdThumbPath", "setThirdThumbPath", "topicContainerLl", "getTopicContainerLl", "topicContainerLl$delegate", "tvCancel", "getTvCancel", "setTvCancel", "tvDesc", "getTvDesc", "setTvDesc", "(Landroid/widget/TextView;)V", "tvPoi", "getTvPoi", "setTvPoi", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "tvVisibility", "getTvVisibility", "setTvVisibility", "updateVPicCallback", "Lcom/tencent/mm/modelimage/UrlImageCacheService$ILoadCallback;", "vBack", "getVBack", "setVBack", "vCamera", "getVCamera", "vCamera$delegate", "vFake", "getVFake", "vFake$delegate", "vMask", "getVMask", "setVMask", "vPic", "getVPic", "vPic$delegate", "vPicLoadUrl", "vPoi", "getVPoi", "setVPoi", "vText", "getVText", "setVText", "vVisibility", "getVVisibility", "setVVisibility", "visibilityClickListener", "visiblityUserNames", "Ljava/util/LinkedList;", "chatRoomToUserList", "", "chatRoomNames", "doWhenLess", "", "text", "doWhenMore", "doWhenOK", "finish", "getBelowAnimator", "height", "getForceOrientation", "getLayoutId", "getTextStatusSet", "getUpAnimator", "handleCaptureResult", "data", "Landroid/content/Intent;", "handleFile", "fileUrl", "thumeUrl", "handleFileLocal", "filePath", "handlePoi", "requestCode", "resultCode", "handleReportData", "hideEmojiKeyboard", "hideSmiley", "initBlur", "initEditPage", "initEditText", "labelToUserList", "", "labelNames", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteEmoji", "onDestroy", "onKeyboardHeightChanged", "isResized", "onPause", "onPressEmoji", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "selectPoi", "setForegroundPic", "bitmap", "setIcon", "id", "setSysInsertionEnabled", "enabled", "showEducationLayout", "showEmojiKeyboard", "showSmiley", "switchPage", "page", "updateBlurStatus", "updateCameraIcon", "updateVPic", "path", "Companion", "PageType", "plugin-textstatus_release"})
public final class TextStatusEditActivity extends MMSecDataActivity implements com.tencent.mm.plugin.textstatus.emoji.c, c.a, com.tencent.mm.ui.tools.g {
    private static Bitmap GeL;
    public static final a GeM = new a((byte) 0);
    private float ABu;
    private com.tencent.mm.xeffect.effect.b AtN;
    private final View.OnClickListener Cfi;
    private final View.OnClickListener Cfj;
    private float Esc;
    private String EvA;
    private String EvB;
    private int Evx;
    private String Evz;
    private TextView FYd;
    TextView FYe;
    public ImageView FYh;
    private TextView FYj;
    private String FZB;
    private FrameLayout Gcu;
    private EditText GdK;
    private View GdL;
    private final kotlin.f GdM = kotlin.g.ah(new ae(this));
    private final kotlin.f GdN = kotlin.g.ah(new af(this));
    private View GdO;
    private View GdP;
    private View GdQ;
    private View GdR;
    private View GdS;
    private View GdT;
    private View GdU;
    Button GdW;
    private TextView GdX;
    private final kotlin.f GdY = kotlin.g.ah(new ag(this));
    private View GdZ;
    private String GeB;
    private final r.a GeC;
    private Integer GeD;
    private b GeE;
    private final View.OnClickListener GeF;
    private final View.OnClickListener GeG;
    private SightCaptureResult GeH;
    private LinkedList<String> GeI;
    private String GeJ;
    private String GeK;
    private ImageView Gea;
    private View Geb;
    private View Gec;
    private View Ged;
    MaxHeightScrollView Gee;
    private View Gef;
    private final kotlin.f Geg = kotlin.g.ah(new ac(this));
    private View Geh;
    private View Gei;
    public View Gej;
    private final kotlin.f Gek = kotlin.g.ah(new d(this));
    public View Gel;
    public View Gem;
    public ImageView Gen;
    private final kotlin.f Geo = kotlin.g.ah(new h(this));
    private final kotlin.f Gep = kotlin.g.ah(new i(this));
    private final kotlin.f Geq = kotlin.g.ah(new z(this));
    private final kotlin.f Ger = kotlin.g.ah(new aa(this));
    private final kotlin.f Ges = kotlin.g.ah(new ab(this));
    private String Get;
    private String Geu;
    com.tencent.mm.plugin.textstatus.a.m Gev;
    boolean Gew;
    private int Gex;
    private Bitmap Gey;
    private com.tencent.mm.videocomposition.n Gez;
    private ObjectAnimator Rsu;
    private long Vef;
    View Vfa;
    public MMEditText Vfb;
    private final kotlin.f Vfc = kotlin.g.ah(new av(this));
    private final kotlin.f Vfd = kotlin.g.ah(new e(this));
    private ObjectAnimator Vfe;
    private boolean Vff;
    private final ak Vfg;
    private final aj Vfh;
    private com.tencent.mm.ui.tools.h gyh;
    private String kHV;
    int mediaType;
    int style;
    private VideoCompositionPlayView wbi;
    private EffectManager wet;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "", "(Ljava/lang/String;I)V", "MAIN", "EDT_DESC", "plugin-textstatus_release"})
    public enum b {
        MAIN,
        EDT_DESC;

        static {
            AppMethodBeat.i(216482);
            AppMethodBeat.o(216482);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(216484);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(216484);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(216562);
        AppMethodBeat.o(216562);
    }

    private final View fwp() {
        AppMethodBeat.i(216526);
        View view = (View) this.GdM.getValue();
        AppMethodBeat.o(216526);
        return view;
    }

    private final View fwq() {
        AppMethodBeat.i(216527);
        View view = (View) this.GdN.getValue();
        AppMethodBeat.o(216527);
        return view;
    }

    private final ImageView fws() {
        AppMethodBeat.i(216529);
        ImageView imageView = (ImageView) this.GdY.getValue();
        AppMethodBeat.o(216529);
        return imageView;
    }

    private final View fwv() {
        AppMethodBeat.i(216533);
        View view = (View) this.Gek.getValue();
        AppMethodBeat.o(216533);
        return view;
    }

    private final ImageView fww() {
        AppMethodBeat.i(216536);
        ImageView imageView = (ImageView) this.Geo.getValue();
        AppMethodBeat.o(216536);
        return imageView;
    }

    private final TextView fwx() {
        AppMethodBeat.i(216537);
        TextView textView = (TextView) this.Gep.getValue();
        AppMethodBeat.o(216537);
        return textView;
    }

    private final FrameLayout fwz() {
        AppMethodBeat.i(216539);
        FrameLayout frameLayout = (FrameLayout) this.Ges.getValue();
        AppMethodBeat.o(216539);
        return frameLayout;
    }

    private final ImeEmojiView hXw() {
        AppMethodBeat.i(258504);
        ImeEmojiView imeEmojiView = (ImeEmojiView) this.Vfd.getValue();
        AppMethodBeat.o(258504);
        return imeEmojiView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00142\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion;", "", "()V", "EDIT_TEXT_MAX_NUM", "", "TAG", "", "lastThumbBlurBitmap", "Landroid/graphics/Bitmap;", "getLastThumbBlurBitmap", "()Landroid/graphics/Bitmap;", "setLastThumbBlurBitmap", "(Landroid/graphics/Bitmap;)V", "start", "", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "startForResult", "Landroid/app/Activity;", "reqCode", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void b(Context context, com.tencent.mm.plugin.textstatus.a.m mVar) {
            Context context2;
            AppMethodBeat.i(216480);
            kotlin.g.b.p.h(context, "context");
            Intent intent = new Intent(context, TextStatusEditActivity.class);
            if (mVar == null) {
                TextStatusDoWhatActivity.a aVar = TextStatusDoWhatActivity.GdF;
                TextStatusDoWhatActivity.a.g(context, null);
                AppMethodBeat.o(216480);
                return;
            }
            intent.putExtra("SET_TEXT_PARAMS", mVar.toByteArray());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (!(context instanceof Activity)) {
                context2 = null;
            } else {
                context2 = context;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                activity.overridePendingTransition(R.anim.dq, R.anim.s);
                AppMethodBeat.o(216480);
                return;
            }
            AppMethodBeat.o(216480);
        }

        public static void a(Activity activity, com.tencent.mm.plugin.textstatus.a.m mVar, int i2) {
            AppMethodBeat.i(258468);
            kotlin.g.b.p.h(activity, "context");
            Intent intent = new Intent(activity, TextStatusEditActivity.class);
            intent.putExtra("SET_TEXT_PARAMS", mVar != null ? mVar.toByteArray() : null);
            activity.startActivityForResult(intent, i2);
            if (activity != null) {
                activity.overridePendingTransition(R.anim.dq, R.anim.s);
                AppMethodBeat.o(258468);
                return;
            }
            AppMethodBeat.o(258468);
        }
    }

    public TextStatusEditActivity() {
        AppMethodBeat.i(216561);
        com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.l());
        com.tencent.mm.plugin.textstatus.j.e eVar = com.tencent.mm.plugin.textstatus.j.e.Ggj;
        this.Gex = com.tencent.mm.plugin.textstatus.j.e.fwL();
        this.Vfg = new ak(this);
        this.Vfh = new aj(this);
        this.GeC = new ad(this);
        this.GeE = b.MAIN;
        this.Cfj = new y(this);
        this.Evz = "";
        this.EvA = "";
        this.EvB = "";
        this.GeF = new ah(this);
        this.Cfi = new j(this);
        this.GeG = new c(this);
        this.GeI = new LinkedList<>();
        this.Esc = -1000.0f;
        this.ABu = -1000.0f;
        AppMethodBeat.o(216561);
    }

    public static final /* synthetic */ FrameLayout a(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(216563);
        FrameLayout fwz = textStatusEditActivity.fwz();
        AppMethodBeat.o(216563);
        return fwz;
    }

    public static final /* synthetic */ void a(TextStatusEditActivity textStatusEditActivity, Bitmap bitmap, String str) {
        AppMethodBeat.i(216566);
        textStatusEditActivity.i(bitmap, str);
        AppMethodBeat.o(216566);
    }

    public static final /* synthetic */ void a(TextStatusEditActivity textStatusEditActivity, b bVar) {
        AppMethodBeat.i(216567);
        textStatusEditActivity.a(bVar);
        AppMethodBeat.o(216567);
    }

    public static final /* synthetic */ View b(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(216564);
        View fwv = textStatusEditActivity.fwv();
        AppMethodBeat.o(216564);
        return fwv;
    }

    public static final /* synthetic */ void d(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(216565);
        textStatusEditActivity.fwA();
        AppMethodBeat.o(216565);
    }

    public static final /* synthetic */ void j(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(258512);
        textStatusEditActivity.hXx();
        AppMethodBeat.o(258512);
    }

    public static final /* synthetic */ ImeEmojiView l(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(258513);
        ImeEmojiView hXw = textStatusEditActivity.hXw();
        AppMethodBeat.o(258513);
        return hXw;
    }

    public static final /* synthetic */ void o(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(258516);
        textStatusEditActivity.gKE();
        AppMethodBeat.o(258516);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2g;
    }

    public final void setEditLayout(View view) {
        this.Vfa = view;
    }

    public final void setIconStatus(View view) {
        this.GdL = view;
    }

    public final void setVText(View view) {
        this.GdO = view;
    }

    public final void setVPoi(View view) {
        this.GdP = view;
    }

    public final void setVVisibility(View view) {
        this.GdQ = view;
    }

    public final void setIconCamera(View view) {
        this.GdR = view;
    }

    public final void setIconText(View view) {
        this.GdS = view;
    }

    public final void setIconPoi(View view) {
        this.GdT = view;
    }

    public final void setIconVisibility(View view) {
        this.GdU = view;
    }

    public final MMEditText hXv() {
        AppMethodBeat.i(258503);
        MMEditText mMEditText = this.Vfb;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        AppMethodBeat.o(258503);
        return mMEditText;
    }

    public final void setFakePic(View view) {
        this.GdZ = view;
    }

    public final ImageView fwt() {
        AppMethodBeat.i(216530);
        ImageView imageView = this.FYh;
        if (imageView == null) {
            kotlin.g.b.p.btv("vBack");
        }
        AppMethodBeat.o(216530);
        return imageView;
    }

    public final void setLayoutShow(View view) {
        this.Geb = view;
    }

    public final void setLayoutEditDesc(View view) {
        this.Gec = view;
    }

    public final void setLayoutEditToolContainer(View view) {
        this.Ged = view;
    }

    public final void setLayoutTopicEdit(View view) {
        this.Gef = view;
    }

    public final void setTvCancel(View view) {
        this.Geh = view;
    }

    public final void setBtnTag(View view) {
        this.Gei = view;
    }

    public final View fwu() {
        AppMethodBeat.i(216531);
        View view = this.Gej;
        if (view == null) {
            kotlin.g.b.p.btv("btnOk");
        }
        AppMethodBeat.o(216531);
        return view;
    }

    public final void setBtnOk(View view) {
        AppMethodBeat.i(216532);
        kotlin.g.b.p.h(view, "<set-?>");
        this.Gej = view;
        AppMethodBeat.o(216532);
    }

    public final void setBtnBack(View view) {
        AppMethodBeat.i(216534);
        kotlin.g.b.p.h(view, "<set-?>");
        this.Gel = view;
        AppMethodBeat.o(216534);
    }

    public final void setLayoutBlurOption(View view) {
        AppMethodBeat.i(216535);
        kotlin.g.b.p.h(view, "<set-?>");
        this.Gem = view;
        AppMethodBeat.o(216535);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode2$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"})
    public static final class ak implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ak(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ ak Vfl;

            a(ak akVar) {
                this.Vfl = akVar;
            }

            public final void run() {
                AppMethodBeat.i(258484);
                this.Vfl.GeQ.hXv().requestFocus();
                com.tencent.f.h.RTc.n(new Runnable(this) {
                    /* class com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ak.a.AnonymousClass1 */
                    final /* synthetic */ a Vfm;

                    {
                        this.Vfm = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(258483);
                        Object systemService = this.Vfm.Vfl.GeQ.getContext().getSystemService("input_method");
                        if (systemService == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                            AppMethodBeat.o(258483);
                            throw tVar;
                        }
                        ((InputMethodManager) systemService).showSoftInput(this.Vfm.Vfl.GeQ.hXv(), 0);
                        AppMethodBeat.o(258483);
                    }
                }, 200);
                AppMethodBeat.o(258484);
            }
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(258485);
            this.GeQ.hXv().post(new a(this));
            this.GeQ.hXv().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(258485);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListenerMode1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"})
    public static final class aj implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        aj(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ aj Vfj;

            a(aj ajVar) {
                this.Vfj = ajVar;
            }

            public final void run() {
                AppMethodBeat.i(258481);
                com.tencent.f.h.RTc.n(new Runnable(this) {
                    /* class com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.aj.a.AnonymousClass1 */
                    final /* synthetic */ a Vfk;

                    {
                        this.Vfk = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(258480);
                        this.Vfk.Vfj.GeQ.hXv().requestFocus();
                        TextStatusEditActivity.n(this.Vfk.Vfj.GeQ);
                        this.Vfk.Vfj.GeQ.hideVKB();
                        AppMethodBeat.o(258480);
                    }
                }, 200);
                AppMethodBeat.o(258481);
            }
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(258482);
            this.GeQ.hXv().post(new a(this));
            this.GeQ.hXv().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(258482);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x043c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0455  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x049d  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x04b1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x056f  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x03bd  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 1452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.onCreate(android.os.Bundle):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class m implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        m(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(216502);
            this.GeQ.finish();
            AppMethodBeat.o(216502);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ar implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;

        ar(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            MaxHeightScrollView maxHeightScrollView;
            AppMethodBeat.i(258498);
            if (this.GeQ.fwt() == null || (maxHeightScrollView = this.GeQ.Gee) == null) {
                AppMethodBeat.o(258498);
                return;
            }
            ImageView fwt = this.GeQ.fwt();
            Integer valueOf = fwt != null ? Integer.valueOf(fwt.getMeasuredHeight()) : null;
            if (valueOf == null) {
                kotlin.g.b.p.hyc();
            }
            maxHeightScrollView.setMaxHeight(valueOf.intValue());
            AppMethodBeat.o(258498);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$5$3$2", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$special$$inlined$let$lambda$1"})
    static final class k implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.a.m GeV;
        final /* synthetic */ String pAl;

        k(String str, com.tencent.mm.plugin.textstatus.a.m mVar, TextStatusEditActivity textStatusEditActivity) {
            this.pAl = str;
            this.GeV = mVar;
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            AppMethodBeat.i(258493);
            final z.f fVar = new z.f();
            fVar.SYG = null;
            com.tencent.mm.plugin.textstatus.i.d dVar = com.tencent.mm.plugin.textstatus.i.d.Gcq;
            String str = this.pAl;
            LinkedList linkedList = this.GeV.Gak;
            kotlin.g.b.p.g(linkedList, "it.jumpInfos");
            Object first = linkedList.getFirst();
            kotlin.g.b.p.g(first, "it.jumpInfos.first");
            fVar.SYG = (T) com.tencent.mm.plugin.textstatus.i.d.a(str, (com.tencent.mm.plugin.textstatus.g.r) first, new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.k.AnonymousClass1 */
                final /* synthetic */ k Vfo;

                {
                    this.Vfo = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(258491);
                    T t = fVar.SYG;
                    if (t != null) {
                        if (t.getVisibility() == 0) {
                            TextStatusEditActivity.a(this.Vfo.GeQ).setVisibility(0);
                        } else {
                            TextStatusEditActivity.a(this.Vfo.GeQ).setVisibility(8);
                        }
                        t.invalidate();
                    } else {
                        TextStatusEditActivity.a(this.Vfo.GeQ).setVisibility(8);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(258491);
                    return xVar;
                }
            });
            final T t = fVar.SYG;
            if (t != null) {
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.k.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(258492);
                        TextStatusEditActivity.a(this.GeQ).setVisibility(0);
                        View view = t;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.width = com.tencent.mm.ui.at.aH(this.GeQ.getContext(), R.dimen.cb);
                        layoutParams.height = com.tencent.mm.ui.at.aH(this.GeQ.getContext(), R.dimen.cb);
                        view.setLayoutParams(layoutParams);
                        TextStatusEditActivity.a(this.GeQ).addView(t);
                        AppMethodBeat.o(258492);
                    }
                });
                AppMethodBeat.o(258493);
                return;
            }
            AppMethodBeat.o(258493);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class u implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        u(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216511);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.GeQ.fwu().isEnabled()) {
                this.GeQ.Tx(null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(216511);
                return;
            }
            com.tencent.mm.ui.tools.b.c.f(this.GeQ.hXv()).a(f.a.MODE_CHINESE_AS_2).lv(1, 64).CN(false).a(this.GeQ);
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo != null) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp + 1;
                    int unused = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp;
                    JSONObject jSONObject = new JSONObject();
                    c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    String str = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo;
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("5", str);
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_SHARE, jSONObject.toString());
                } else {
                    c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp + 1;
                    int unused2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEp;
                    com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                    c.a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                    mVar2.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo, s.ba.PERSIONAL_STATE_SHARE_SUCC);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216511);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class v implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        v(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216512);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.Tx(null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216512);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class w implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        w(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216513);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216513);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class x implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        x(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216514);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.hideVKB();
            TextStatusEditActivity.j(this.GeQ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216514);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        n(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216503);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.Cfi.onClick(view);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Ves = 1 + abVar.Ves;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216503);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        o(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            Editable text;
            AppMethodBeat.i(258494);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MMEditText hXv = this.GeQ.hXv();
            if (!(hXv == null || (text = hXv.getText()) == null)) {
                MMEditText hXv2 = this.GeQ.hXv();
                text.insert((hXv2 != null ? Integer.valueOf(hXv2.getSelectionStart()) : null).intValue(), this.GeQ.getContext().getString(R.string.hk_));
            }
            this.GeQ.hXv().requestFocus();
            Object systemService = this.GeQ.getContext().getSystemService("input_method");
            if (systemService == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.o(258494);
                throw tVar;
            }
            ((InputMethodManager) systemService).showSoftInput(this.GeQ.hXv(), 0);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Vep = 1 + abVar.Vep;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258494);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$12", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"})
    public static final class p implements TextWatcher {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(258495);
            View fwu = this.GeQ.fwu();
            Editable text = this.GeQ.hXv().getText();
            kotlin.g.b.p.g(text, "etDesc.text");
            fwu.setEnabled(!kotlin.n.n.aL(text));
            if (this.GeQ.fwu().isEnabled()) {
                TextStatusEditActivity.b(this.GeQ).setVisibility(8);
            } else {
                TextStatusEditActivity.b(this.GeQ).setVisibility(0);
            }
            String valueOf = String.valueOf(editable);
            if (com.tencent.mm.ui.tools.f.a(valueOf, f.a.MODE_CHINESE_AS_2) > 64) {
                String hm = com.tencent.mm.ui.tools.f.hm(valueOf, 64);
                if (editable != null) {
                    try {
                        editable.replace(hm.length(), valueOf.length(), "");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.TxtStatus.TextStatusEditActivity", "etDesc replace: " + e2.getMessage());
                    }
                }
                this.GeQ.dv(null);
            }
            AppMethodBeat.o(258495);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class q implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        q(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216507);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusDoWhatActivity.a aVar = TextStatusDoWhatActivity.GdF;
            TextStatusEditActivity textStatusEditActivity = this.GeQ;
            int i2 = this.GeQ.Gex;
            kotlin.g.b.p.h(textStatusEditActivity, "context");
            Intent intent = new Intent(textStatusEditActivity, TextStatusDoWhatActivity.class);
            intent.putExtra("KEY_DEFAULT_BACKGROUND_ID", i2);
            textStatusEditActivity.startActivityForResult(intent, 3);
            if (textStatusEditActivity != null) {
                textStatusEditActivity.overridePendingTransition(R.anim.dq, R.anim.s);
            }
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Veo = 1 + abVar.Veo;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216507);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class r implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        r(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216508);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.Cfi.onClick(view);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Ver = 1 + abVar.Ver;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216508);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ap implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        ap(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258496);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Button button = this.GeQ.GdW;
            if (button != null) {
                button.performClick();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258496);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class aq implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        aq(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258497);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GeQ.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258497);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        g(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(216494);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.GeQ.mediaType == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(216494);
                return;
            }
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                if (this.GeQ.Gew) {
                    abVar.Vex++;
                } else {
                    abVar.Vew++;
                }
            }
            TextStatusEditActivity textStatusEditActivity = this.GeQ;
            if (!this.GeQ.Gew) {
                z = true;
            } else {
                z = false;
            }
            textStatusEditActivity.Gew = z;
            TextStatusEditActivity.d(this.GeQ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216494);
        }
    }

    private final void fwA() {
        AppMethodBeat.i(216541);
        if (this.Gew) {
            View view = this.Gem;
            if (view == null) {
                kotlin.g.b.p.btv("layoutBlurOption");
            }
            view.setAlpha(1.0f);
            ImageView imageView = this.Gen;
            if (imageView == null) {
                kotlin.g.b.p.btv("ivBlur");
            }
            imageView.setVisibility(8);
            fww().setVisibility(0);
            fwx().setTextColor(getContext().getResources().getColor(R.color.am));
            ImageView imageView2 = this.Gea;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            EffectManager effectManager = this.wet;
            if (effectManager != null) {
                effectManager.a(this.AtN);
            }
            if (GeL != null) {
                fws().setImageBitmap(GeL);
                AppMethodBeat.o(216541);
                return;
            }
        } else {
            View view2 = this.Gem;
            if (view2 == null) {
                kotlin.g.b.p.btv("layoutBlurOption");
            }
            view2.setAlpha(0.85f);
            ImageView imageView3 = this.Gen;
            if (imageView3 == null) {
                kotlin.g.b.p.btv("ivBlur");
            }
            imageView3.setVisibility(0);
            fww().setVisibility(8);
            fwx().setTextColor(getContext().getResources().getColor(R.color.BW_100_Alpha_0_6));
            ImageView imageView4 = this.Gea;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            EffectManager effectManager2 = this.wet;
            if (effectManager2 != null) {
                effectManager2.hiv();
            }
            if (this.Gey != null) {
                fws().setImageBitmap(this.Gey);
            }
        }
        AppMethodBeat.o(216541);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
    static final class ad implements r.a {
        final /* synthetic */ TextStatusEditActivity GeQ;

        ad(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        @Override // com.tencent.mm.av.r.a
        public final void a(String str, Bitmap bitmap, String str2) {
            AppMethodBeat.i(216521);
            TextStatusEditActivity.a(this.GeQ, bitmap, str2);
            AppMethodBeat.o(216521);
        }
    }

    private final void i(Bitmap bitmap, String str) {
        AppMethodBeat.i(216542);
        fws().setImageBitmap(bitmap);
        this.GeK = str;
        com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
        GeL = com.tencent.mm.plugin.textstatus.j.f.a(bitmap, this, 10.0f);
        this.Gey = bitmap;
        fwA();
        AppMethodBeat.o(216542);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$handleFileLocal$1$1"})
    static final class f implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;
        final /* synthetic */ VideoCompositionPlayView GeT;
        final /* synthetic */ FrameLayout.LayoutParams GeU;
        final /* synthetic */ String uJI;

        f(VideoCompositionPlayView videoCompositionPlayView, TextStatusEditActivity textStatusEditActivity, FrameLayout.LayoutParams layoutParams, String str) {
            this.GeT = videoCompositionPlayView;
            this.GeQ = textStatusEditActivity;
            this.GeU = layoutParams;
            this.uJI = str;
        }

        public final void run() {
            AppMethodBeat.i(216493);
            try {
                com.tencent.mm.videocomposition.n nVar = new com.tencent.mm.videocomposition.n();
                EffectManager effectManager = new EffectManager();
                TextStatusEditActivity textStatusEditActivity = this.GeQ;
                com.tencent.mm.xeffect.effect.ad a2 = effectManager.a(com.tencent.mm.xeffect.effect.j.BlurEffect);
                if (!(a2 instanceof com.tencent.mm.xeffect.effect.b)) {
                    a2 = null;
                }
                textStatusEditActivity.AtN = (com.tencent.mm.xeffect.effect.b) a2;
                com.tencent.mm.xeffect.effect.b bVar = this.GeQ.AtN;
                if (bVar != null) {
                    bVar.setRadius(3.5f);
                }
                nVar.e(new com.tencent.mm.videocomposition.d(this.uJI, 2));
                nVar.lW(this.GeT.getWidth(), this.GeT.getHeight());
                nVar.GAw = effectManager;
                this.GeT.setLoop(true);
                this.GeT.a(nVar);
                this.GeQ.Gez = nVar;
                this.GeQ.wet = effectManager;
                this.GeQ.AtN = this.GeQ.AtN;
                AppMethodBeat.o(216493);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.TxtStatus.TextStatusEditActivity", th, "video play err", new Object[0]);
                AppMethodBeat.o(216493);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(216543);
        super.onDestroy();
        VideoCompositionPlayView videoCompositionPlayView = this.wbi;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.stop();
        }
        VideoCompositionPlayView videoCompositionPlayView2 = this.wbi;
        if (videoCompositionPlayView2 != null) {
            videoCompositionPlayView2.release();
        }
        EffectManager effectManager = this.wet;
        if (effectManager != null) {
            effectManager.destroy();
        }
        hXw().setOnKeyboardActionListener(null);
        ObjectAnimator objectAnimator = this.Vfe;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.Rsu;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            objectAnimator2.cancel();
        }
        com.tencent.mm.av.q.bcU().b(this.GeB, this.GeC);
        GeL = null;
        this.Gey = null;
        com.tencent.mm.plugin.textstatus.a.m mVar = this.Gev;
        if (mVar != null) {
            String str = mVar.Gah;
            if (str != null) {
                com.tencent.mm.plugin.textstatus.i.d dVar = com.tencent.mm.plugin.textstatus.i.d.Gcq;
                LinkedList linkedList = mVar.Gak;
                kotlin.g.b.p.g(linkedList, "it.jumpInfos");
                Object first = linkedList.getFirst();
                kotlin.g.b.p.g(first, "it.jumpInfos.first");
                com.tencent.mm.plugin.textstatus.i.d.b(str, (com.tencent.mm.plugin.textstatus.g.r) first);
                AppMethodBeat.o(216543);
                return;
            }
            AppMethodBeat.o(216543);
            return;
        }
        AppMethodBeat.o(216543);
    }

    private final void aC(Bitmap bitmap) {
        AppMethodBeat.i(216544);
        if (bitmap != null) {
            fws().setImageBitmap(bitmap);
            fws().setVisibility(0);
            FrameLayout frameLayout = this.Gcu;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
            GeL = com.tencent.mm.plugin.textstatus.j.f.a(bitmap, this, 10.0f);
            this.Gey = bitmap;
        }
        AppMethodBeat.o(216544);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(216545);
        super.onResume();
        com.tencent.mm.ui.tools.h hVar = this.gyh;
        if (hVar != null) {
            hVar.start();
        }
        if (!com.tencent.mm.plugin.textstatus.a.p.hXm()) {
            MMEditText mMEditText = this.Vfb;
            if (mMEditText == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText.post(new at(this));
        }
        AppMethodBeat.o(216545);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class at implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;

        at(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            AppMethodBeat.i(258500);
            this.GeQ.hideVKB();
            AppMethodBeat.o(258500);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(216546);
        super.onPause();
        com.tencent.mm.ui.tools.h hVar = this.gyh;
        if (hVar != null) {
            hVar.close();
        }
        hXx();
        AppMethodBeat.o(216546);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z2) {
        AppMethodBeat.i(216547);
        AppMethodBeat.at(this, z2);
        super.onWindowFocusChanged(z2);
        if (z2) {
            com.tencent.mm.ui.tools.h hVar = this.gyh;
            if (hVar != null) {
                hVar.start();
                AppMethodBeat.o(216547);
                return;
            }
            AppMethodBeat.o(216547);
            return;
        }
        com.tencent.mm.ui.tools.h hVar2 = this.gyh;
        if (hVar2 != null) {
            hVar2.close();
            AppMethodBeat.o(216547);
            return;
        }
        AppMethodBeat.o(216547);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z2) {
        int[] iArr;
        int[] iArr2 = null;
        AppMethodBeat.i(216548);
        Log.d("MicroMsg.TxtStatus.TextStatusEditActivity", "keyboardHeight " + i2 + ", " + z2);
        Integer num = this.GeD;
        if (num != null && num.intValue() == i2) {
            AppMethodBeat.o(216548);
            return;
        }
        this.GeD = Integer.valueOf(i2);
        if (i2 > 0) {
            int aH = i2 - com.tencent.mm.ui.at.aH(getContext(), R.dimen.cb);
            View view = this.Ged;
            if (view != null) {
                view.setTranslationY(Math.min((float) (-aH), 0.0f));
            }
            View view2 = this.Geb;
            if (view2 != null) {
                iArr = com.tencent.mm.ac.d.cn(view2);
            } else {
                iArr = null;
            }
            View view3 = this.Ged;
            if (view3 != null) {
                iArr2 = com.tencent.mm.ac.d.cn(view3);
            }
            View view4 = this.Geb;
            if (!(iArr == null || iArr2 == null || view4 == null)) {
                view4.setTranslationY(Math.min((float) (((iArr2[1] - iArr[1]) / 2) - (view4.getMeasuredHeight() / 3)), 0.0f));
            }
        } else {
            Window window = getWindow();
            kotlin.g.b.p.g(window, "window");
            window.setNavigationBarColor(getResources().getColor(R.color.y));
            View view5 = this.Geb;
            if (view5 != null) {
                view5.setTranslationY(0.0f);
            }
            View view6 = this.Ged;
            if (view6 != null) {
                view6.setTranslationY(0.0f);
            }
        }
        if (!com.tencent.mm.plugin.textstatus.a.p.hXm() && i2 > 0) {
            MMEditText mMEditText = this.Vfb;
            if (mMEditText == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText.post(new as(this));
        }
        AppMethodBeat.o(216548);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class as implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;

        as(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            AppMethodBeat.i(258499);
            this.GeQ.hideVKB();
            AppMethodBeat.o(258499);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(216549);
        switch (h.$EnumSwitchMapping$0[this.GeE.ordinal()]) {
            case 1:
                a(b.MAIN);
                AppMethodBeat.o(216549);
                return;
            default:
                super.onBackPressed();
                getContext().overridePendingTransition(R.anim.s, R.anim.f6do);
                AppMethodBeat.o(216549);
                return;
        }
    }

    private final void a(b bVar) {
        AppMethodBeat.i(216550);
        switch (h.haE[bVar.ordinal()]) {
            case 1:
                View view = this.Gec;
                if (view != null) {
                    view.setVisibility(8);
                }
                View view2 = this.Geb;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = this.Ged;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                com.tencent.mm.ui.t controller = getController();
                kotlin.g.b.p.g(controller, "controller");
                controller.gIM().show();
                break;
            case 2:
                View view4 = this.Gec;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                View view5 = this.Geb;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                View view6 = this.Ged;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
                com.tencent.mm.ui.t controller2 = getController();
                kotlin.g.b.p.g(controller2, "controller");
                controller2.gIM().hide();
                hideVKB();
                break;
        }
        this.GeE = bVar;
        AppMethodBeat.o(216550);
    }

    private final void hXx() {
        AppMethodBeat.i(258505);
        if (hXw().getVisibility() == 8) {
            AppMethodBeat.o(258505);
            return;
        }
        int bD = com.tencent.mm.api.ad.bD(this);
        hXw().getLayoutParams().height = bD;
        ObjectAnimator axo = axo(bD);
        if (axo != null && axo.isRunning()) {
            axo.cancel();
        }
        ObjectAnimator axp = axp(bD);
        if (axp != null) {
            axp.start();
            AppMethodBeat.o(258505);
            return;
        }
        AppMethodBeat.o(258505);
    }

    private final ObjectAnimator axo(int i2) {
        AppMethodBeat.i(258506);
        if (this.Vfe == null) {
            this.Vfe = ObjectAnimator.ofFloat(hXw(), View.TRANSLATION_Y, (float) i2, 0.0f);
            ObjectAnimator objectAnimator = this.Vfe;
            if (objectAnimator != null) {
                objectAnimator.setDuration(300L);
            }
            ObjectAnimator objectAnimator2 = this.Vfe;
            if (objectAnimator2 != null) {
                objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            ObjectAnimator objectAnimator3 = this.Vfe;
            if (objectAnimator3 != null) {
                objectAnimator3.addUpdateListener(new t(this, i2));
            }
        }
        ObjectAnimator objectAnimator4 = this.Vfe;
        if (objectAnimator4 != null) {
            objectAnimator4.removeAllListeners();
        }
        ObjectAnimator objectAnimator5 = this.Vfe;
        if (objectAnimator5 != null) {
            objectAnimator5.addListener(new ai(this));
        }
        ObjectAnimator objectAnimator6 = this.Vfe;
        AppMethodBeat.o(258506);
        return objectAnimator6;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class t implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextStatusEditActivity GeQ;
        final /* synthetic */ int cKF;

        t(TextStatusEditActivity textStatusEditActivity, int i2) {
            this.GeQ = textStatusEditActivity;
            this.cKF = i2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            AppMethodBeat.i(258475);
            if (valueAnimator != null) {
                obj = valueAnimator.getAnimatedValue();
            } else {
                obj = null;
            }
            if (!(obj instanceof Float)) {
                obj = null;
            }
            Float f2 = (Float) obj;
            this.GeQ.y((int) (((float) this.cKF) - (f2 != null ? f2.floatValue() : 0.0f)), false);
            AppMethodBeat.o(258475);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getUpAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
    public static final class ai implements Animator.AnimatorListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ai(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(258476);
            kotlin.g.b.p.h(animator, "animation");
            TextStatusEditActivity.l(this.GeQ).setVisibility(0);
            AppMethodBeat.o(258476);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(258477);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(258477);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(258478);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(258478);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(258479);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(258479);
        }
    }

    private final ObjectAnimator axp(int i2) {
        AppMethodBeat.i(258507);
        if (this.Rsu == null) {
            this.Rsu = ObjectAnimator.ofFloat(hXw(), View.TRANSLATION_Y, 0.0f, (float) i2);
            ObjectAnimator objectAnimator = this.Rsu;
            if (objectAnimator != null) {
                objectAnimator.setDuration(300L);
            }
            ObjectAnimator objectAnimator2 = this.Rsu;
            if (objectAnimator2 != null) {
                objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            ObjectAnimator objectAnimator3 = this.Rsu;
            if (objectAnimator3 != null) {
                objectAnimator3.addUpdateListener(new l(this, i2));
            }
        }
        ObjectAnimator objectAnimator4 = this.Rsu;
        if (objectAnimator4 != null) {
            objectAnimator4.removeAllListeners();
        }
        ObjectAnimator objectAnimator5 = this.Rsu;
        if (objectAnimator5 != null) {
            objectAnimator5.addListener(new s(this));
        }
        ObjectAnimator objectAnimator6 = this.Rsu;
        AppMethodBeat.o(258507);
        return objectAnimator6;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class l implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextStatusEditActivity GeQ;
        final /* synthetic */ int cKF;

        l(TextStatusEditActivity textStatusEditActivity, int i2) {
            this.GeQ = textStatusEditActivity;
            this.cKF = i2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            AppMethodBeat.i(258470);
            if (valueAnimator != null) {
                obj = valueAnimator.getAnimatedValue();
            } else {
                obj = null;
            }
            if (!(obj instanceof Float)) {
                obj = null;
            }
            Float f2 = (Float) obj;
            this.GeQ.y((int) (((float) this.cKF) - (f2 != null ? f2.floatValue() : 0.0f)), false);
            AppMethodBeat.o(258470);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$getBelowAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
    public static final class s implements Animator.AnimatorListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        s(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(258471);
            kotlin.g.b.p.h(animator, "animation");
            TextStatusEditActivity.l(this.GeQ).setVisibility(0);
            AppMethodBeat.o(258471);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(258472);
            kotlin.g.b.p.h(animator, "animation");
            TextStatusEditActivity.l(this.GeQ).setVisibility(8);
            AppMethodBeat.o(258472);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(258473);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(258473);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(258474);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(258474);
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.emoji.c
    public final void byq(String str) {
        AppMethodBeat.i(258508);
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "onPressEmoji : ".concat(String.valueOf(str)));
        MMEditText mMEditText = this.Vfb;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        if (com.tencent.mm.ui.tools.f.a(mMEditText.getText().toString() + str, f.a.MODE_CHINESE_AS_2) > 64) {
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Vem = 1 + abVar.Vem;
                AppMethodBeat.o(258508);
                return;
            }
            AppMethodBeat.o(258508);
            return;
        }
        MMEditText mMEditText2 = this.Vfb;
        if (mMEditText2 == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        mMEditText2.bol(str);
        AppMethodBeat.o(258508);
    }

    @Override // com.tencent.mm.plugin.textstatus.emoji.c
    public final void hXo() {
        AppMethodBeat.i(258509);
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "onDeleteEmoji");
        MMEditText mMEditText = this.Vfb;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        InputConnection inputConnection = mMEditText.getInputConnection();
        if (inputConnection != null) {
            inputConnection.sendKeyEvent(new KeyEvent(0, 67));
            inputConnection.sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.o(258509);
            return;
        }
        AppMethodBeat.o(258509);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class y implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        y(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216516);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditActivity.a(this.GeQ, b.EDT_DESC);
            MMEditText hXv = this.GeQ.hXv();
            if (hXv != null) {
                hXv.requestFocus();
            }
            MMActivity.showVKB(this.GeQ);
            Button button = this.GeQ.GdW;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.y.AnonymousClass1 */
                    final /* synthetic */ y GeY;

                    {
                        this.GeY = r1;
                    }

                    public final void onClick(View view) {
                        boolean z;
                        CharSequence charSequence = null;
                        AppMethodBeat.i(216515);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        TextView textView = this.GeY.GeQ.FYe;
                        if (textView != null) {
                            MMEditText hXv = this.GeY.GeQ.hXv();
                            textView.setText(hXv != null ? hXv.getText() : null);
                        }
                        TextView textView2 = this.GeY.GeQ.FYe;
                        if (textView2 != null) {
                            charSequence = textView2.getText();
                        }
                        if (charSequence == null || kotlin.n.n.aL(charSequence)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            TextView textView3 = this.GeY.GeQ.FYe;
                            if (textView3 != null) {
                                textView3.setVisibility(8);
                            }
                        } else {
                            TextView textView4 = this.GeY.GeQ.FYe;
                            if (textView4 != null) {
                                textView4.setVisibility(0);
                            }
                        }
                        this.GeY.GeQ.hideVKB(this.GeY.GeQ.hXv());
                        TextStatusEditActivity.a(this.GeY.GeQ, b.MAIN);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(216515);
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216516);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class ah implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        ah(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216525);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.GeQ, SnsLabelUI.class);
            intent.putExtra("KLabel_range_index", this.GeQ.Evx);
            intent.putExtra("Klabel_name_list", this.GeQ.Evz);
            intent.putExtra("Kother_user_name_list", this.GeQ.EvA);
            intent.putExtra("Kchat_room_name_list", this.GeQ.EvB);
            intent.putExtra("Kis_from_text_status", true);
            intent.putExtra("k_show_private", false);
            intent.putExtra("k_show_include", false);
            intent.putExtra("k_sns_label_ui_style", this.GeQ.style);
            this.GeQ.startActivityForResult(intent, 4);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Veu = 1 + abVar.Veu;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216525);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        j(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(216497);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(274436);
            if (obj == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(216497);
                throw tVar;
            }
            if (com.tencent.mm.aw.b.Pi((String) obj)) {
                if (!com.tencent.mm.pluginsdk.permission.b.n(this.GeQ.getContext(), "android.permission.ACCESS_FINE_LOCATION") || !com.tencent.mm.pluginsdk.permission.b.n(this.GeQ.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                    Object obj2 = aAh2.azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE);
                    if (obj2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
                        AppMethodBeat.o(216497);
                        throw tVar2;
                    }
                    if (!((Boolean) obj2).booleanValue()) {
                        com.tencent.mm.plugin.account.a.b.a.b(this.GeQ.getContext(), this.GeQ.getString(R.string.el_, new Object[]{LocaleUtil.getApplicationLanguage()}), 30764, true);
                    } else {
                        com.tencent.mm.pluginsdk.permission.b.a(this.GeQ.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(216497);
                    return;
                }
            } else {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.GeQ.getContext(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64, (String) null, (String) null);
                Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(216497);
                    return;
                }
            }
            this.GeQ.fwB();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216497);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(216551);
        kotlin.g.b.p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        kotlin.g.b.p.h(iArr, "grantResults");
        if (iArr.length == 0) {
            AppMethodBeat.o(216551);
        } else if (i2 == 64 && iArr[0] == 0) {
            fwB();
            AppMethodBeat.o(216551);
        } else {
            if (i2 == 16 && iArr[0] == 0) {
                this.GeG.onClick(new View(getContext()));
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
            AppMethodBeat.o(216551);
        }
    }

    public final void fwB() {
        AppMethodBeat.i(216552);
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        com.tencent.mm.br.c.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
        AppMethodBeat.o(216552);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        c(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1$generateCallback$1", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$SimpleVideoGenerateCallback;", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-textstatus_release"})
        public static final class a extends CaptureDataManager.c {
            final /* synthetic */ c Vfi;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(c cVar) {
                this.Vfi = cVar;
            }

            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
            public final void a(Context context, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
                AppMethodBeat.i(216486);
                kotlin.g.b.p.h(context, "context");
                kotlin.g.b.p.h(captureVideoNormalModel, "model");
                kotlin.g.b.p.h(bundle, "extData");
                cly cly = new cly();
                cly.Mrn = true;
                cly.Mrm = false;
                SightCaptureResult sightCaptureResult = new SightCaptureResult(true, captureVideoNormalModel.getVideoPath(), captureVideoNormalModel.aQn(), com.tencent.mm.vfs.s.bpb(captureVideoNormalModel.getVideoPath()), com.tencent.xweb.util.d.getMD5(captureVideoNormalModel.getVideoPath()), Math.round((((float) captureVideoNormalModel.eJH().longValue()) * 1.0f) / 1000.0f), cly);
                Boolean eJI = captureVideoNormalModel.eJI();
                kotlin.g.b.p.g(eJI, "model.getPhoto()");
                if (eJI.booleanValue()) {
                    sightCaptureResult.zsy = true;
                    sightCaptureResult.tkD = false;
                    sightCaptureResult.zsG = captureVideoNormalModel.aQn();
                }
                SecDataUIC.a aVar = SecDataUIC.CWq;
                AppCompatActivity context2 = this.Vfi.GeQ.getContext();
                kotlin.g.b.p.g(context2, "getContext()");
                com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context2, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
                if (abVar != null) {
                    Object y = captureVideoNormalModel.eJJ().y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", 0L);
                    kotlin.g.b.p.g(y, "model.reportInfo.getRepo…DIA_DURATION_MS_LONG, 0L)");
                    abVar.Vec = ((Number) y).longValue();
                    abVar.Vef = (long) (((Number) captureVideoNormalModel.eJJ().y("KEY_MEDIA_SOURCE_INT", 0)).intValue() + 1);
                    com.tencent.mm.plugin.textstatus.a.m mVar = this.Vfi.GeQ.Gev;
                    if (!(mVar == null || mVar.Gah == null)) {
                        abVar.Vel = 1;
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("key_req_result", sightCaptureResult);
                ((Activity) context).setResult(-1, intent);
                ((Activity) context).finish();
                AppMethodBeat.o(216486);
            }

            @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c, com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
            public final boolean a(Context context, Bundle bundle, CaptureDataManager.a aVar) {
                AppMethodBeat.i(216487);
                kotlin.g.b.p.h(context, "context");
                kotlin.g.b.p.h(bundle, "extData");
                kotlin.g.b.p.h(aVar, "finishController");
                AppMethodBeat.o(216487);
                return false;
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216488);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = new a(this);
            new SightParams(1, 0);
            String Qv = com.tencent.mm.modelvideo.t.Qv(com.tencent.mm.plugin.auth.a.a.ceA());
            kotlin.g.b.p.g(Qv, "VideoInfoStorage.genFileName(Account.username())");
            com.tencent.mm.modelvideo.o.bhj();
            String Qw = com.tencent.mm.modelvideo.t.Qw(Qv);
            com.tencent.mm.modelvideo.o.bhj();
            RecordConfigProvider a2 = RecordConfigProvider.a(Qw, com.tencent.mm.modelvideo.t.Qx(Qv), ((c.a) com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm, ((c.a) com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm.duration * 1000, 15);
            kotlin.g.b.p.g(a2, "RecordConfigProvider.get…ENE_TEXT_STATUS\n        )");
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2c_ignore_remux_without_edit, false)) {
                a2.remuxType = 2;
            }
            UICustomParam.a aVar2 = new UICustomParam.a();
            aVar2.apE();
            aVar2.apD();
            aVar2.dz(true);
            a2.BOn = aVar2.apG();
            a2.BOu = Boolean.TRUE;
            a2.BOG = false;
            a2.BOH = false;
            a2.BOI = true;
            a2.BOq = Boolean.TRUE;
            a2.BOp = 4;
            a2.F(2, TextStatusEditVideoPluginLayout.class.getName());
            a2.F(1, TextStatusEditPhotoPluginLayout.class.getName());
            a2.F(0, TextStatusRecordPluginLayout.class.getName());
            CaptureDataManager.BOb.a(aVar);
            com.tencent.mm.plugin.recordvideo.jumper.a aVar3 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
            com.tencent.mm.plugin.recordvideo.jumper.a.a(this.GeQ, 2, R.anim.ei, R.anim.ej, a2);
            SecDataUIC.a aVar4 = SecDataUIC.CWq;
            AppCompatActivity context = this.GeQ.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.Veq = 1 + abVar.Veq;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216488);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        String nullAs;
        String str;
        String str2;
        SightCaptureResult sightCaptureResult;
        String str3;
        int i4;
        CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel;
        int i5 = 1;
        int i6 = 0;
        AppMethodBeat.i(216553);
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "onActivityResult");
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 2:
                if (intent != null) {
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                } else {
                    sightCaptureResult = null;
                }
                if (sightCaptureResult != null) {
                    if (!(intent == null || (captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO")) == null)) {
                        this.Vef = (long) (((Number) captureVideoNormalModel.eJJ().y("KEY_MEDIA_SOURCE_INT", 0)).intValue() + 1);
                    }
                    this.GeH = sightCaptureResult;
                    String str4 = null;
                    if (sightCaptureResult.tkD) {
                        str4 = sightCaptureResult.zsB;
                    } else if (sightCaptureResult.zsy) {
                        str4 = sightCaptureResult.zsG;
                    }
                    if (sightCaptureResult.tkD) {
                        str3 = sightCaptureResult.zsA;
                    } else {
                        str3 = sightCaptureResult.zsG;
                    }
                    Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "[handleCaptureResult]isVideo:%s,thumbPath:%s,filePath:%s", Boolean.valueOf(sightCaptureResult.tkD), str4, str3);
                    if (sightCaptureResult.tkD) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    String str5 = str3;
                    if (str5 != null && !kotlin.n.n.aL(str5)) {
                        i5 = 0;
                    }
                    if (i5 == 0) {
                        View view = this.Gem;
                        if (view == null) {
                            kotlin.g.b.p.btv("layoutBlurOption");
                        }
                        view.setVisibility(0);
                        this.mediaType = i4;
                        if (i4 == 2) {
                            Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "handle video file");
                            fws().setVisibility(8);
                            FrameLayout frameLayout = this.Gcu;
                            if (frameLayout != null) {
                                frameLayout.setVisibility(0);
                            }
                            View view2 = this.GdZ;
                            int measuredWidth = view2 != null ? view2.getMeasuredWidth() : 0;
                            View view3 = this.GdZ;
                            if (view3 != null) {
                                i6 = view3.getMeasuredHeight();
                            }
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, i6);
                            layoutParams.gravity = 17;
                            VideoCompositionPlayView videoCompositionPlayView = new VideoCompositionPlayView(this);
                            FrameLayout frameLayout2 = this.Gcu;
                            if (frameLayout2 != null) {
                                frameLayout2.addView(videoCompositionPlayView, layoutParams);
                            }
                            videoCompositionPlayView.post(new f(videoCompositionPlayView, this, layoutParams, str3));
                            this.wbi = videoCompositionPlayView;
                            com.tencent.mm.plugin.textstatus.j.f fVar = com.tencent.mm.plugin.textstatus.j.f.Ggk;
                            com.tencent.mm.plugin.textstatus.j.f.B(this.wbi, (float) com.tencent.mm.cb.a.fromDPToPix((Context) this, 12.0f));
                        } else {
                            aC(BitmapUtil.decodeFileWithSample(str3));
                        }
                    }
                    fwA();
                    if (sightCaptureResult.tkD) {
                        SecDataUIC.a aVar = SecDataUIC.CWq;
                        AppCompatActivity context = getContext();
                        kotlin.g.b.p.g(context, "context");
                        com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
                        if (abVar != null) {
                            abVar.Ved = ((long) sightCaptureResult.zsE) * 1000;
                            abVar.Vee = com.tencent.mm.vfs.s.boW(sightCaptureResult.zsB) + com.tencent.mm.vfs.s.boW(sightCaptureResult.zsA);
                        }
                    } else {
                        SecDataUIC.a aVar2 = SecDataUIC.CWq;
                        AppCompatActivity context2 = getContext();
                        kotlin.g.b.p.g(context2, "context");
                        com.tencent.mm.plugin.textstatus.g.ab abVar2 = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context2, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
                        if (abVar2 != null) {
                            abVar2.Vee = com.tencent.mm.vfs.s.boW(sightCaptureResult.zsG);
                        }
                    }
                    SecDataUIC.a aVar3 = SecDataUIC.CWq;
                    AppCompatActivity context3 = getContext();
                    kotlin.g.b.p.g(context3, "context");
                    com.tencent.mm.plugin.textstatus.g.ab abVar3 = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context3, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
                    if (abVar3 != null) {
                        abVar3.Vef = this.Vef;
                        com.tencent.mm.plugin.textstatus.a.m mVar = this.Gev;
                        if (mVar != null) {
                            if (mVar.Gah != null) {
                                abVar3.Vel = 1;
                            }
                            AppMethodBeat.o(216553);
                            return;
                        }
                        AppMethodBeat.o(216553);
                        return;
                    }
                }
                AppMethodBeat.o(216553);
                return;
            case 3:
                if (i3 == -1) {
                    if (intent == null || (str = intent.getStringExtra("STATUS_TYPE_IMG")) == null) {
                        str = "";
                    }
                    this.Get = str;
                    setIcon(this.Get);
                    if (intent == null || (str2 = intent.getStringExtra("STATUS_TYPE_NAME")) == null) {
                        str2 = "";
                    }
                    TextView textView = this.FYd;
                    if (textView != null) {
                        textView.setText(str2);
                        AppMethodBeat.o(216553);
                        return;
                    }
                    AppMethodBeat.o(216553);
                    return;
                }
                break;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(216553);
                    return;
                }
                this.Evx = intent.getIntExtra("Ktag_range_index", 0);
                String stringExtra = intent.getStringExtra("Klabel_name_list");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                this.Evz = stringExtra;
                String stringExtra2 = intent.getStringExtra("Kother_user_name_list");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                this.EvA = stringExtra2;
                String stringExtra3 = intent.getStringExtra("Kchat_room_name_list");
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                this.EvB = stringExtra3;
                this.GeI.clear();
                if (!Util.isNullOrNil(this.EvB)) {
                    Object[] array = new kotlin.n.k(",").q(this.EvB, 0).toArray(new String[0]);
                    if (array == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(216553);
                        throw tVar;
                    }
                    String[] strArr = (String[]) array;
                    this.GeI.addAll(hH(kotlin.a.j.listOf((Object[]) ((String[]) Arrays.copyOf(strArr, strArr.length)))));
                } else {
                    i5 = 0;
                }
                if (!Util.isNullOrNil(this.Evz)) {
                    Object[] array2 = new kotlin.n.k(",").q(this.Evz, 0).toArray(new String[0]);
                    if (array2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(216553);
                        throw tVar2;
                    }
                    String[] strArr2 = (String[]) array2;
                    this.GeI.addAll(hG(kotlin.a.j.listOf((Object[]) ((String[]) Arrays.copyOf(strArr2, strArr2.length)))));
                    i5 |= 4;
                }
                if (!Util.isNullOrNil(this.EvA)) {
                    Object[] array3 = new kotlin.n.k(",").q(this.EvA, 0).toArray(new String[0]);
                    if (array3 == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(216553);
                        throw tVar3;
                    }
                    String[] strArr3 = (String[]) array3;
                    this.GeI.addAll(kotlin.a.j.listOf((Object[]) ((String[]) Arrays.copyOf(strArr3, strArr3.length))));
                    i5 |= 2;
                }
                switch (this.Evx) {
                    case 0:
                        TextView textView2 = this.GdX;
                        if (textView2 != null) {
                            textView2.setText(getContext().getString(R.string.ho2));
                        }
                        i5 = 0;
                        break;
                    case 3:
                        TextView textView3 = this.GdX;
                        if (textView3 != null) {
                            textView3.setText(getContext().getString(R.string.ho4));
                            break;
                        }
                        break;
                }
                SecDataUIC.a aVar4 = SecDataUIC.CWq;
                AppCompatActivity context4 = getContext();
                kotlin.g.b.p.g(context4, "context");
                com.tencent.mm.plugin.textstatus.g.ab abVar4 = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context4, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
                if (abVar4 != null) {
                    abVar4.Vev = i5;
                    AppMethodBeat.o(216553);
                    return;
                }
                break;
            case 10:
                Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "intent ".concat(String.valueOf(intent)));
                if (i3 != -1) {
                    TextView textView4 = this.FYj;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                        AppMethodBeat.o(216553);
                        return;
                    }
                    AppMethodBeat.o(216553);
                    return;
                }
                if (intent != null) {
                    String stringExtra4 = intent.getStringExtra("get_poi_name");
                    String stringExtra5 = intent.getStringExtra("get_city");
                    if (!Util.isNullOrNil(stringExtra4) || !Util.isNullOrNil(stringExtra5)) {
                        nullAs = Util.nullAs(stringExtra4, stringExtra5);
                    } else {
                        nullAs = null;
                    }
                    this.kHV = nullAs;
                    this.Esc = intent.getFloatExtra("get_lat", -1000.0f);
                    this.ABu = intent.getFloatExtra("get_lng", -1000.0f);
                    this.GeJ = Util.nullAs(intent.getStringExtra("get_poi_classify_id"), "");
                }
                if (!Util.isNullOrNil(this.kHV)) {
                    TextView textView5 = this.FYj;
                    if (textView5 != null) {
                        textView5.setText(this.kHV);
                    }
                    TextView textView6 = this.FYj;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                        AppMethodBeat.o(216553);
                        return;
                    }
                    AppMethodBeat.o(216553);
                    return;
                }
                TextView textView7 = this.FYj;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                    AppMethodBeat.o(216553);
                    return;
                }
                AppMethodBeat.o(216553);
                return;
        }
        AppMethodBeat.o(216553);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(216522);
            View findViewById = this.GeQ.findViewById(R.id.j25);
            AppMethodBeat.o(216522);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(216523);
            View findViewById = this.GeQ.findViewById(R.id.j26);
            AppMethodBeat.o(216523);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ag(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216524);
            ImageView imageView = (ImageView) this.GeQ.findViewById(R.id.j29);
            AppMethodBeat.o(216524);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(216520);
            View findViewById = this.GeQ.findViewById(R.id.itk);
            AppMethodBeat.o(216520);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(216489);
            View findViewById = this.GeQ.findViewById(R.id.cav);
            AppMethodBeat.o(216489);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216495);
            ImageView imageView = (ImageView) this.GeQ.findViewById(R.id.e4a);
            AppMethodBeat.o(216495);
            return imageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(216496);
            TextView textView = (TextView) this.GeQ.findViewById(R.id.e4b);
            AppMethodBeat.o(216496);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(216517);
            LinearLayout linearLayout = (LinearLayout) this.GeQ.findViewById(R.id.ilg);
            AppMethodBeat.o(216517);
            return linearLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(216518);
            TextView textView = (TextView) this.GeQ.findViewById(R.id.ilh);
            AppMethodBeat.o(216518);
            return textView;
        }
    }

    private static Collection<String> hG(List<String> list) {
        AppMethodBeat.i(216554);
        if (list == null || list.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(216554);
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        for (String str : list) {
            List<String> aCK = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH(str));
            if (aCK == null || aCK.size() == 0) {
                break;
            }
            for (String str2 : aCK) {
                hashSet.add(str2);
            }
        }
        ArrayList arrayList2 = new ArrayList(hashSet);
        AppMethodBeat.o(216554);
        return arrayList2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(216519);
            FrameLayout frameLayout = (FrameLayout) this.GeQ.findViewById(R.id.ili);
            AppMethodBeat.o(216519);
            return frameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class av extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        av(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(258502);
            FrameLayout frameLayout = (FrameLayout) this.GeQ.findViewById(R.id.k2m);
            AppMethodBeat.o(258502);
            return frameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<ImeEmojiView> {
        final /* synthetic */ TextStatusEditActivity GeQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TextStatusEditActivity textStatusEditActivity) {
            super(0);
            this.GeQ = textStatusEditActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImeEmojiView invoke() {
            AppMethodBeat.i(258469);
            ImeEmojiView imeEmojiView = (ImeEmojiView) this.GeQ.findViewById(R.id.juk);
            AppMethodBeat.o(258469);
            return imeEmojiView;
        }
    }

    private static List<String> hH(List<String> list) {
        AppMethodBeat.i(216555);
        LinkedList linkedList = new LinkedList();
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(216555);
            return linkedList2;
        } else if (list == null) {
            LinkedList linkedList3 = linkedList;
            AppMethodBeat.o(216555);
            return linkedList3;
        } else {
            for (String str : list) {
                List<String> Id = com.tencent.mm.model.v.Id(str);
                if (Id != null) {
                    for (String str2 : Id) {
                        if (!linkedList.contains(str2) && com.tencent.mm.model.ab.IS(str2)) {
                            linkedList.add(str2);
                        }
                    }
                }
            }
            LinkedList linkedList4 = linkedList;
            AppMethodBeat.o(216555);
            return linkedList4;
        }
    }

    private final void setIcon(String str) {
        View view;
        AppMethodBeat.i(216556);
        String str2 = str;
        if (!(str2 == null || kotlin.n.n.aL(str2))) {
            this.Get = str;
            SecDataUIC.a aVar = SecDataUIC.CWq;
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(this, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.VdZ.add(this.Get);
            }
            com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
            Drawable a2 = com.tencent.mm.plugin.textstatus.j.b.a(this.Get, null, null, 6);
            if (!(a2 == null || (view = this.GdL) == null)) {
                view.setBackground(a2);
                AppMethodBeat.o(216556);
                return;
            }
        }
        AppMethodBeat.o(216556);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        long j2;
        long j3;
        long j4;
        long j5 = 1;
        AppMethodBeat.i(216557);
        PluginTextStatus.a aVar = PluginTextStatus.FXb;
        PluginTextStatus.access$setSIsNeedUpdateTitle$cp(true);
        hideVKB();
        MMEditText mMEditText = this.Vfb;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        String obj = mMEditText.getText().toString();
        com.tencent.mm.plugin.textstatus.a.m mVar = this.Gev;
        if (!(mVar == null || mVar.Gah == null)) {
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                if (Util.isNullOrNil(mVar.desc)) {
                    j3 = 0;
                } else {
                    j3 = Util.isEqual(mVar.desc, obj) ? 0 : 1;
                }
                abVar.Vej = j3;
                if (abVar.VdZ.size() == 1) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                abVar.Vek = j4;
            }
        }
        SecDataUIC.a aVar3 = SecDataUIC.CWq;
        AppCompatActivity context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        com.tencent.mm.plugin.textstatus.g.ab abVar2 = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context2, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar2 != null) {
            abVar2.Veg = (long) com.tencent.mm.ui.tools.f.a(obj, f.a.MODE_CHINESE_AS_2);
            if (Util.isNullOrNil(this.kHV)) {
                j2 = 0;
            } else {
                j2 = 1;
            }
            abVar2.Vet = j2;
            if (!this.Gew) {
                j5 = 0;
            }
            abVar2.Vey = j5;
        }
        SecDataUIC.a aVar4 = SecDataUIC.CWq;
        AppCompatActivity context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        com.tencent.mm.plugin.textstatus.g.ab abVar3 = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context3, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar3 != null) {
            com.tencent.mm.plugin.textstatus.k.a aVar5 = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.a(this.Vff, abVar3);
        }
        super.finish();
        AppMethodBeat.o(216557);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tx(String str) {
        AppMethodBeat.i(216558);
        if (com.tencent.mm.plugin.textstatus.a.p.hXm()) {
            com.tencent.mm.ui.base.u.u(this, getString(R.string.gr5), R.raw.icons_outlined_info);
        } else {
            com.tencent.mm.ui.base.u.u(this, getString(R.string.jdv), R.raw.icons_outlined_info);
        }
        SecDataUIC.a aVar = SecDataUIC.CWq;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar != null) {
            abVar.Ven = 1 + abVar.Ven;
            AppMethodBeat.o(216558);
            return;
        }
        AppMethodBeat.o(216558);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void dv(String str) {
        AppMethodBeat.i(216559);
        com.tencent.mm.ui.base.u.u(this, getString(R.string.gr6), R.raw.icons_outlined_info);
        SecDataUIC.a aVar = SecDataUIC.CWq;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar != null) {
            abVar.Vem = 1 + abVar.Vem;
            AppMethodBeat.o(216559);
            return;
        }
        AppMethodBeat.o(216559);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tw(String str) {
        LinkedList<String> linkedList;
        int i2;
        boolean z2;
        long j2;
        String str2;
        int i3 = 0;
        AppMethodBeat.i(216560);
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "Set New textStatus : " + Util.secPrint(str));
        hideVKB();
        MMEditText mMEditText = this.Vfb;
        if (mMEditText == null) {
            kotlin.g.b.p.btv("etDesc");
        }
        Editable text = mMEditText.getText();
        switch (this.Evx) {
            case 3:
                linkedList = this.GeI;
                break;
            default:
                linkedList = null;
                break;
        }
        com.tencent.mm.plugin.textstatus.f.h.d dVar = com.tencent.mm.plugin.textstatus.f.h.d.Gaa;
        com.tencent.mm.plugin.textstatus.g.v vVar = new com.tencent.mm.plugin.textstatus.g.v();
        SecDataUIC.a aVar = SecDataUIC.CWq;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(context, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar != null) {
            vVar.VdX = abVar.VdX;
        }
        vVar.GaW = true;
        SightCaptureResult sightCaptureResult = this.GeH;
        if (sightCaptureResult != null) {
            vVar.GaW = false;
            if (sightCaptureResult.tkD) {
                vVar.GaX = sightCaptureResult.zsA;
                vVar.thumbPath = sightCaptureResult.zsB;
                i3 = 2;
            } else {
                vVar.GaX = sightCaptureResult.zsG;
                vVar.thumbPath = sightCaptureResult.zsG;
                i3 = 1;
            }
        } else {
            com.tencent.mm.plugin.textstatus.a.m mVar = this.Gev;
            if (mVar != null) {
                if (mVar.Gah != null && mVar.mediaType == 1) {
                    String str3 = mVar.thumbUrl;
                    if (str3 == null || kotlin.n.n.aL(str3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        vVar.GaX = this.GeK;
                        vVar.thumbPath = this.GeK;
                        vVar.GaW = false;
                        i2 = 1;
                        i3 = i2;
                    }
                }
                i2 = 0;
                i3 = i2;
            }
        }
        com.tencent.mm.plugin.textstatus.g.g gVar = new com.tencent.mm.plugin.textstatus.g.g();
        gVar.longitude = (double) this.ABu;
        gVar.latitude = (double) this.Esc;
        gVar.Gat = i3;
        com.tencent.mm.plugin.textstatus.g.w wVar = new com.tencent.mm.plugin.textstatus.g.w();
        com.tencent.mm.plugin.textstatus.j.e eVar = com.tencent.mm.plugin.textstatus.j.e.Ggj;
        Matcher matcher = com.tencent.mm.plugin.textstatus.j.e.fwK().matcher(text.toString());
        while (matcher.find()) {
            wVar.Gbc.add(matcher.group(1));
        }
        wVar.Gan = String.valueOf(this.Get);
        com.tencent.mm.plugin.textstatus.a.m mVar2 = this.Gev;
        if (!(mVar2 == null || (str2 = mVar2.Gah) == null)) {
            wVar.Gao = str2;
            wVar.Gap = mVar2.Gai;
            wVar.Gbf = mVar2.fuN;
            wVar.Gal = mVar2.iFo;
            wVar.Gam = mVar2.Gaj;
            wVar.Gbe = mVar2.Gak;
        }
        if (kotlin.g.b.p.j(wVar.Gan, "custom")) {
            wVar.title = this.FZB;
        }
        gVar.Gau = wVar;
        gVar.description = text.toString();
        int a2 = com.tencent.mm.ui.tools.f.a(gVar.description, f.a.MODE_CHINESE_AS_2);
        if (a2 > 64) {
            try {
                gVar.description = gVar.description.subSequence(0, com.tencent.mm.ui.tools.f.hm(gVar.description, 64).length()).toString();
                Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "check desc " + Util.secPrint(gVar.description) + " count:" + a2);
            } catch (Exception e2) {
                Log.e("MicroMsg.TxtStatus.TextStatusEditActivity", "doWhenOK replace: " + e2.getMessage());
            }
        }
        gVar.Gaz = cl.aWB();
        gVar.pRN = gVar.Gaz + LocalCache.TIME_DAY;
        gVar.GaA = this.GeJ;
        gVar.iUX = this.kHV;
        if (this.Gew) {
            j2 = com.tencent.mm.plugin.textstatus.f.b.a.TextStatusOptionBlur.value;
        } else {
            j2 = com.tencent.mm.plugin.textstatus.f.b.a.TextStatusOptionNo.value;
        }
        gVar.GaB = j2;
        if (vVar.GaW) {
            com.tencent.mm.plugin.textstatus.j.e eVar2 = com.tencent.mm.plugin.textstatus.j.e.Ggj;
            gVar.GaC = com.tencent.mm.plugin.textstatus.j.e.abN(this.Gex);
        } else if (i3 == 1) {
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(vVar.GaX);
            if (imageOptions != null) {
                gVar.zGN = imageOptions.outWidth;
                gVar.zGO = imageOptions.outHeight;
            }
        } else {
            MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
            String str4 = vVar.GaX;
            kotlin.g.b.p.g(str4, "uploadFilePath");
            MultiMediaVideoChecker.a aTV = multiMediaVideoChecker.aTV(str4);
            if (aTV != null) {
                gVar.zGN = aTV.width;
                gVar.zGO = aTV.height;
            }
        }
        vVar.GaU = gVar;
        vVar.GaV = linkedList;
        com.tencent.mm.plugin.textstatus.f.h.d.b(vVar);
        com.tencent.mm.plugin.textstatus.a.m mVar3 = this.Gev;
        if (!(mVar3 == null || mVar3.Gah == null)) {
            com.tencent.mm.ui.base.u.u(this, getString(R.string.yw), R.raw.icons_outlined_done);
        }
        setResult(-1);
        this.Vff = true;
        finish();
        AppMethodBeat.o(216560);
    }

    private final void gKE() {
        AppMethodBeat.i(258510);
        if (com.tencent.mm.plugin.textstatus.a.p.hXm()) {
            if (!hXy()) {
                Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "initEditText allow input text");
                MMEditText mMEditText = this.Vfb;
                if (mMEditText == null) {
                    kotlin.g.b.p.btv("etDesc");
                }
                mMEditText.getViewTreeObserver().addOnGlobalLayoutListener(this.Vfg);
                MMEditText mMEditText2 = this.Vfb;
                if (mMEditText2 == null) {
                    kotlin.g.b.p.btv("etDesc");
                }
                if (Util.isNullOrNil(mMEditText2.getText())) {
                    MMEditText mMEditText3 = this.Vfb;
                    if (mMEditText3 == null) {
                        kotlin.g.b.p.btv("etDesc");
                    }
                    mMEditText3.post(new al(this));
                }
                View view = this.Gei;
                if (view != null) {
                    view.setVisibility(0);
                }
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1629, 0, 1, false);
                AppMethodBeat.o(258510);
                return;
            }
        } else if (!hXy()) {
            Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "initEditText not allow input text");
            MMEditText mMEditText4 = this.Vfb;
            if (mMEditText4 == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText4.getViewTreeObserver().addOnGlobalLayoutListener(this.Vfh);
            MMEditText mMEditText5 = this.Vfb;
            if (mMEditText5 == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText5.setShowSoftInputOnFocus(false);
            hideVKB();
            MMEditText mMEditText6 = this.Vfb;
            if (mMEditText6 == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText6.setOnLongClickListener(am.Vfn);
            MMEditText mMEditText7 = this.Vfb;
            if (mMEditText7 == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            mMEditText7.setOnTouchListener(new an(this));
            MMEditText mMEditText8 = this.Vfb;
            if (mMEditText8 == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            if (Util.isNullOrNil(mMEditText8.getText())) {
                MMEditText mMEditText9 = this.Vfb;
                if (mMEditText9 == null) {
                    kotlin.g.b.p.btv("etDesc");
                }
                mMEditText9.post(new ao(this));
            }
            View view2 = this.Gei;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1629, 1, 1, false);
        }
        AppMethodBeat.o(258510);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class al implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;

        al(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            AppMethodBeat.i(258486);
            com.tencent.mm.ui.ao.a(this.GeQ.hXv().getPaint(), 0.8f);
            this.GeQ.hXv().setHint(R.string.je2);
            AppMethodBeat.o(258486);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class am implements View.OnLongClickListener {
        public static final am Vfn = new am();

        static {
            AppMethodBeat.i(258488);
            AppMethodBeat.o(258488);
        }

        am() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(258487);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initEditText$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initEditText$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(258487);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class an implements View.OnTouchListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        an(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(258489);
            kotlin.g.b.p.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                TextStatusEditActivity.m(this.GeQ);
                TextStatusEditActivity.n(this.GeQ);
                this.GeQ.hideVKB();
            }
            AppMethodBeat.o(258489);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class ao implements Runnable {
        final /* synthetic */ TextStatusEditActivity GeQ;

        ao(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void run() {
            AppMethodBeat.i(258490);
            com.tencent.mm.ui.ao.a(this.GeQ.hXv().getPaint(), 0.8f);
            this.GeQ.hXv().setHint(R.string.je1);
            AppMethodBeat.o(258490);
        }
    }

    private final boolean hXy() {
        AppMethodBeat.i(258511);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        boolean z2 = aAh.azQ().getInt(ar.a.USERINFO_TEXT_STATUS_EDUCATION_FLAG_INT, 1) == 1;
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        boolean z3 = aAh2.azQ().getBoolean(ar.a.USERINFO_TEXT_STATUS_NEW_TIPS_SHOW_BOOLEAN, false);
        if (!z2 || z3) {
            AppMethodBeat.o(258511);
            return false;
        }
        View findViewById = findViewById(R.id.jui);
        kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.education_layout)");
        findViewById.setVisibility(0);
        View findViewById2 = findViewById(R.id.jui);
        kotlin.g.b.p.g(findViewById2, "findViewById<View>(R.id.education_layout)");
        findViewById2.setBackground(new BitmapDrawable(getResources(), BitmapUtil.getBitmapNative(this.Gex)));
        View view = this.Vfa;
        if (view != null) {
            view.setVisibility(8);
        }
        SecDataUIC.a aVar = SecDataUIC.CWq;
        com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(this, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
        if (abVar != null) {
            abVar.VdL = 1;
        }
        com.tencent.mm.plugin.textstatus.a.p.fvE();
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
        aAh3.azQ().set(ar.a.USERINFO_TEXT_STATUS_EDUCATION_FLAG_INT, (Object) 0);
        findViewById(R.id.juh).setOnClickListener(new au(this));
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "show education");
        AppMethodBeat.o(258511);
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class au implements View.OnClickListener {
        final /* synthetic */ TextStatusEditActivity GeQ;

        au(TextStatusEditActivity textStatusEditActivity) {
            this.GeQ = textStatusEditActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(258501);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$showEducationLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View findViewById = this.GeQ.findViewById(R.id.jui);
            kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.education_layout)");
            findViewById.setVisibility(8);
            View view2 = this.GeQ.Vfa;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            TextStatusEditActivity.o(this.GeQ);
            SecDataUIC.a aVar = SecDataUIC.CWq;
            com.tencent.mm.plugin.textstatus.g.ab abVar = (com.tencent.mm.plugin.textstatus.g.ab) SecDataUIC.a.a(this.GeQ, 8, com.tencent.mm.plugin.textstatus.g.ab.class);
            if (abVar != null) {
                abVar.VdM = 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$showEducationLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(258501);
        }
    }

    public static final /* synthetic */ void m(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(258514);
        try {
            com.tencent.mm.ui.as.d("MicroMsg.TxtStatus.TextStatusEditActivity", "setInsertionDisabled", new Object[0]);
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            kotlin.g.b.p.g(declaredField, "TextView::class.java.getDeclaredField(\"mEditor\")");
            declaredField.setAccessible(true);
            MMEditText mMEditText = textStatusEditActivity.Vfb;
            if (mMEditText == null) {
                kotlin.g.b.p.btv("etDesc");
            }
            Object obj = declaredField.get(mMEditText);
            Class<?> cls = Class.forName("android.widget.Editor");
            kotlin.g.b.p.g(cls, "Class.forName(\"android.widget.Editor\")");
            Field declaredField2 = cls.getDeclaredField("mInsertionControllerEnabled");
            kotlin.g.b.p.g(declaredField2, "editorClass.getDeclaredF…ertionControllerEnabled\")");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, Boolean.FALSE);
            Field declaredField3 = cls.getDeclaredField("mSelectionControllerEnabled");
            kotlin.g.b.p.g(declaredField3, "editorClass.getDeclaredF…ectionControllerEnabled\")");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, Boolean.FALSE);
            AppMethodBeat.o(258514);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TxtStatus.TextStatusEditActivity", e2, "setInsertionDisabled error msg:%s", new Object[0]);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1629, 2, 1, false);
            AppMethodBeat.o(258514);
        }
    }

    public static final /* synthetic */ void n(TextStatusEditActivity textStatusEditActivity) {
        AppMethodBeat.i(258515);
        if (textStatusEditActivity.hXw().getVisibility() != 0) {
            int bD = com.tencent.mm.api.ad.bD(textStatusEditActivity);
            textStatusEditActivity.hXw().getLayoutParams().height = bD;
            ObjectAnimator axp = textStatusEditActivity.axp(bD);
            if (axp != null && axp.isRunning()) {
                axp.cancel();
            }
            ObjectAnimator axo = textStatusEditActivity.axo(com.tencent.mm.api.ad.bD(textStatusEditActivity));
            if (axo != null) {
                axo.start();
                AppMethodBeat.o(258515);
                return;
            }
        }
        AppMethodBeat.o(258515);
    }
}
