package io.flutter.view;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import io.flutter.embedding.engine.c.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a extends AccessibilityNodeProvider {
    private static int STR = 267386881;
    private final io.flutter.embedding.engine.c.a SNY;
    public e SNu;
    public final AccessibilityViewEmbedder STS;
    final io.flutter.plugin.platform.g STT;
    final Map<Integer, f> STU;
    private final Map<Integer, c> STV;
    public f STW;
    public Integer STX;
    public Integer STY;
    private int STZ;
    public f SUa;
    f SUb;
    public f SUc;
    final List<Integer> SUd;
    int SUe;
    Integer SUf;
    private final a.AbstractC2246a SUg;
    private final AccessibilityManager.AccessibilityStateChangeListener SUh;
    @TargetApi(19)
    private final AccessibilityManager.TouchExplorationStateChangeListener SUi;
    private final ContentObserver SUj;
    private final ContentResolver aFp;
    public final AccessibilityManager nC;
    final View rootAccessibilityView;

    public interface e {
        void bm(boolean z, boolean z2);
    }

    static /* synthetic */ void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(9768);
        aVar.mU(i2, i3);
        AppMethodBeat.o(9768);
    }

    static /* synthetic */ void a(a aVar, AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(9770);
        aVar.sendAccessibilityEvent(accessibilityEvent);
        AppMethodBeat.o(9770);
    }

    static /* synthetic */ f b(a aVar, int i2) {
        AppMethodBeat.i(214928);
        f atF = aVar.atF(i2);
        AppMethodBeat.o(214928);
        return atF;
    }

    static /* synthetic */ AccessibilityEvent c(a aVar) {
        AppMethodBeat.i(9769);
        AccessibilityEvent mV = aVar.mV(0, 32);
        AppMethodBeat.o(9769);
        return mV;
    }

    static /* synthetic */ c c(a aVar, int i2) {
        AppMethodBeat.i(214929);
        c atG = aVar.atG(i2);
        AppMethodBeat.o(214929);
        return atG;
    }

    static /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(9772);
        aVar.hxw();
        AppMethodBeat.o(9772);
    }

    public a(View view, io.flutter.embedding.engine.c.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.g gVar) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), gVar);
        AppMethodBeat.i(9750);
        AppMethodBeat.o(9750);
    }

    private a(View view, io.flutter.embedding.engine.c.a aVar, final AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.g gVar) {
        AppMethodBeat.i(214926);
        this.STU = new HashMap();
        this.STV = new HashMap();
        this.STZ = 0;
        this.SUd = new ArrayList();
        this.SUe = 0;
        this.SUf = 0;
        this.SUg = new a.AbstractC2246a() {
            /* class io.flutter.view.a.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.c.a.AbstractC2246a
            public final void bte(String str) {
                AppMethodBeat.i(9688);
                a.this.rootAccessibilityView.announceForAccessibility(str);
                AppMethodBeat.o(9688);
            }

            @Override // io.flutter.embedding.engine.c.a.AbstractC2246a
            public final void atq(int i2) {
                AppMethodBeat.i(9689);
                a.a(a.this, i2, 1);
                AppMethodBeat.o(9689);
            }

            @Override // io.flutter.embedding.engine.c.a.AbstractC2246a
            public final void atr(int i2) {
                AppMethodBeat.i(9690);
                a.a(a.this, i2, 2);
                AppMethodBeat.o(9690);
            }

            @Override // io.flutter.embedding.engine.c.a.AbstractC2246a
            public final void btf(String str) {
                AppMethodBeat.i(9691);
                AccessibilityEvent c2 = a.c(a.this);
                c2.getText().add(str);
                a.a(a.this, c2);
                AppMethodBeat.o(9691);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public final void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                String str;
                String str2;
                AppMethodBeat.i(9692);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                a aVar = a.this;
                while (byteBuffer.hasRemaining()) {
                    c atG = aVar.atG(byteBuffer.getInt());
                    atG.SUN = byteBuffer.getInt();
                    int i2 = byteBuffer.getInt();
                    if (i2 == -1) {
                        str = null;
                    } else {
                        str = strArr[i2];
                    }
                    atG.label = str;
                    int i3 = byteBuffer.getInt();
                    if (i3 == -1) {
                        str2 = null;
                    } else {
                        str2 = strArr[i3];
                    }
                    atG.hint = str2;
                }
                AppMethodBeat.o(9692);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public final void updateSemantics(ByteBuffer byteBuffer, String[] strArr) {
                boolean z;
                String str;
                String str2;
                boolean z2;
                float f2;
                float f3;
                WindowInsets rootWindowInsets;
                AppMethodBeat.i(9693);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                a aVar = a.this;
                ArrayList arrayList = new ArrayList();
                while (byteBuffer.hasRemaining()) {
                    f atF = aVar.atF(byteBuffer.getInt());
                    atF.a(byteBuffer, strArr);
                    if (!atF.a(d.IS_HIDDEN)) {
                        if (atF.a(d.IS_FOCUSED)) {
                            aVar.SUa = atF;
                        }
                        if (atF.SVz) {
                            arrayList.add(atF);
                        }
                    }
                }
                Set<f> hashSet = new HashSet<>();
                f hxv = aVar.hxv();
                ArrayList<f> arrayList2 = new ArrayList();
                if (hxv != null) {
                    float[] fArr = new float[16];
                    Matrix.setIdentityM(fArr, 0);
                    if (Build.VERSION.SDK_INT >= 23 && (rootWindowInsets = aVar.rootAccessibilityView.getRootWindowInsets()) != null) {
                        if (!aVar.SUf.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                            hxv.SVR = true;
                            hxv.SVP = true;
                        }
                        aVar.SUf = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                        Matrix.translateM(fArr, 0, (float) aVar.SUf.intValue(), 0.0f, 0.0f);
                    }
                    hxv.a(fArr, hashSet, false);
                    hxv.kp(arrayList2);
                }
                f fVar = null;
                for (f fVar2 : arrayList2) {
                    if (aVar.SUd.contains(Integer.valueOf(fVar2.id))) {
                        fVar2 = fVar;
                    }
                    fVar = fVar2;
                }
                if (fVar == null && arrayList2.size() > 0) {
                    fVar = arrayList2.get(arrayList2.size() - 1);
                }
                if (!(fVar == null || fVar.id == aVar.SUe)) {
                    aVar.SUe = fVar.id;
                    AccessibilityEvent mV = aVar.mV(fVar.id, 32);
                    mV.getText().add(fVar.hxx());
                    aVar.sendAccessibilityEvent(mV);
                }
                aVar.SUd.clear();
                for (f fVar3 : arrayList2) {
                    aVar.SUd.add(Integer.valueOf(fVar3.id));
                }
                Iterator<Map.Entry<Integer, f>> it = aVar.STU.entrySet().iterator();
                while (it.hasNext()) {
                    f value = it.next().getValue();
                    if (!hashSet.contains(value)) {
                        value.SVJ = null;
                        if (!(value.SVq == -1 || aVar.STX == null || aVar.STS.platformViewOfNode(aVar.STX.intValue()) != aVar.STT.r(Integer.valueOf(value.SVq)))) {
                            aVar.mU(aVar.STX.intValue(), 65536);
                            aVar.STX = null;
                        }
                        if (aVar.STW == value) {
                            aVar.mU(aVar.STW.id, 65536);
                            aVar.STW = null;
                        }
                        if (aVar.SUa == value) {
                            aVar.SUa = null;
                        }
                        if (aVar.SUc == value) {
                            aVar.SUc = null;
                        }
                        it.remove();
                    }
                }
                aVar.atH(0);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f fVar4 = (f) it2.next();
                    if (Float.isNaN(fVar4.SVt) || Float.isNaN(fVar4.SVE) || fVar4.SVE == fVar4.SVt) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        AccessibilityEvent mV2 = aVar.mV(fVar4.id, 4096);
                        float f4 = fVar4.SVt;
                        float f5 = fVar4.SVu;
                        if (Float.isInfinite(fVar4.SVu)) {
                            f5 = 100000.0f;
                            if (f4 > 70000.0f) {
                                f4 = 70000.0f;
                            }
                        }
                        if (Float.isInfinite(fVar4.SVv)) {
                            f2 = f5 + 100000.0f;
                            if (f4 < -70000.0f) {
                                f4 = -70000.0f;
                            }
                            f3 = f4 + 100000.0f;
                        } else {
                            f2 = f5 - fVar4.SVv;
                            f3 = f4 - fVar4.SVv;
                        }
                        if (fVar4.b(b.SCROLL_UP) || fVar4.b(b.SCROLL_DOWN)) {
                            mV2.setScrollY((int) f3);
                            mV2.setMaxScrollY((int) f2);
                        } else if (fVar4.b(b.SCROLL_LEFT) || fVar4.b(b.SCROLL_RIGHT)) {
                            mV2.setScrollX((int) f3);
                            mV2.setMaxScrollX((int) f2);
                        }
                        if (fVar4.SVr > 0) {
                            mV2.setItemCount(fVar4.SVr);
                            mV2.setFromIndex(fVar4.SVs);
                            int i2 = 0;
                            for (f fVar5 : fVar4.SVL) {
                                if (!fVar5.a(d.IS_HIDDEN)) {
                                    i2++;
                                } else {
                                    i2 = i2;
                                }
                            }
                            mV2.setToIndex((fVar4.SVs + i2) - 1);
                        }
                        aVar.sendAccessibilityEvent(mV2);
                    }
                    if (fVar4.a(d.IS_LIVE_REGION)) {
                        if (!(fVar4.label == null && fVar4.SVI == null) && (fVar4.label == null || fVar4.SVI == null || !fVar4.label.equals(fVar4.SVI))) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            aVar.atH(fVar4.id);
                        }
                    }
                    if (aVar.STW != null && aVar.STW.id == fVar4.id && !fVar4.b(d.IS_SELECTED) && fVar4.a(d.IS_SELECTED)) {
                        AccessibilityEvent mV3 = aVar.mV(fVar4.id, 4);
                        mV3.getText().add(fVar4.label);
                        aVar.sendAccessibilityEvent(mV3);
                    }
                    if (aVar.SUa != null && aVar.SUa.id == fVar4.id && (aVar.SUb == null || aVar.SUb.id != aVar.SUa.id)) {
                        aVar.SUb = aVar.SUa;
                        aVar.sendAccessibilityEvent(aVar.mV(fVar4.id, 8));
                    } else if (aVar.SUa == null) {
                        aVar.SUb = null;
                    }
                    if (aVar.SUa != null && aVar.SUa.id == fVar4.id && fVar4.b(d.IS_TEXT_FIELD) && fVar4.a(d.IS_TEXT_FIELD)) {
                        if (aVar.STW == null || aVar.STW.id == aVar.SUa.id) {
                            if (fVar4.SVH != null) {
                                str = fVar4.SVH;
                            } else {
                                str = "";
                            }
                            if (fVar4.value != null) {
                                str2 = fVar4.value;
                            } else {
                                str2 = "";
                            }
                            AccessibilityEvent ae = aVar.ae(fVar4.id, str, str2);
                            if (ae != null) {
                                aVar.sendAccessibilityEvent(ae);
                            }
                            if (fVar4.SVC != fVar4.SVo || fVar4.SVD != fVar4.SVp) {
                                AccessibilityEvent mV4 = aVar.mV(fVar4.id, 8192);
                                mV4.getText().add(str2);
                                mV4.setFromIndex(fVar4.SVo);
                                mV4.setToIndex(fVar4.SVp);
                                mV4.setItemCount(str2.length());
                                aVar.sendAccessibilityEvent(mV4);
                            }
                        }
                    }
                }
                AppMethodBeat.o(9693);
            }
        };
        this.SUh = new AccessibilityManager.AccessibilityStateChangeListener() {
            /* class io.flutter.view.a.AnonymousClass2 */

            public final void onAccessibilityStateChanged(boolean z) {
                AppMethodBeat.i(9797);
                if (z) {
                    a.this.SNY.a(a.this.SUg);
                    a.this.SNY.SNV.setSemanticsEnabled(true);
                } else {
                    a.this.SNY.a(null);
                    a.this.SNY.SNV.setSemanticsEnabled(false);
                }
                if (a.this.SNu != null) {
                    a.this.SNu.bm(z, a.this.nC.isTouchExplorationEnabled());
                }
                AppMethodBeat.o(9797);
            }
        };
        this.SUj = new ContentObserver(new Handler()) {
            /* class io.flutter.view.a.AnonymousClass3 */

            public final void onChange(boolean z) {
                AppMethodBeat.i(9776);
                onChange(z, null);
                AppMethodBeat.o(9776);
            }

            public final void onChange(boolean z, Uri uri) {
                String string;
                AppMethodBeat.i(9777);
                if (Build.VERSION.SDK_INT < 17) {
                    string = null;
                } else {
                    string = Settings.Global.getString(a.this.aFp, "transition_animation_scale");
                }
                if (string != null && string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    a.this.STZ |= EnumC2255a.DISABLE_ANIMATIONS.value;
                } else {
                    a.this.STZ &= EnumC2255a.DISABLE_ANIMATIONS.value ^ -1;
                }
                a.j(a.this);
                AppMethodBeat.o(9777);
            }
        };
        this.rootAccessibilityView = view;
        this.SNY = aVar;
        this.nC = accessibilityManager;
        this.aFp = contentResolver;
        this.STS = accessibilityViewEmbedder;
        this.STT = gVar;
        this.SUh.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        this.nC.addAccessibilityStateChangeListener(this.SUh);
        if (Build.VERSION.SDK_INT >= 19) {
            this.SUi = new AccessibilityManager.TouchExplorationStateChangeListener() {
                /* class io.flutter.view.a.AnonymousClass4 */

                public final void onTouchExplorationStateChanged(boolean z) {
                    AppMethodBeat.i(9778);
                    if (z) {
                        a.this.STZ |= EnumC2255a.ACCESSIBLE_NAVIGATION.value;
                    } else {
                        a.k(a.this);
                        a.this.STZ &= EnumC2255a.ACCESSIBLE_NAVIGATION.value ^ -1;
                    }
                    a.j(a.this);
                    if (a.this.SNu != null) {
                        a.this.SNu.bm(accessibilityManager.isEnabled(), z);
                    }
                    AppMethodBeat.o(9778);
                }
            };
            this.SUi.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            this.nC.addTouchExplorationStateChangeListener(this.SUi);
        } else {
            this.SUi = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.SUj.onChange(false);
            this.aFp.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.SUj);
        }
        if (gVar != null) {
            gVar.a(this);
        }
        AppMethodBeat.o(214926);
    }

    public final void release() {
        AppMethodBeat.i(9751);
        if (this.STT != null) {
            this.STT.hxq();
        }
        this.SNu = null;
        this.nC.removeAccessibilityStateChangeListener(this.SUh);
        if (Build.VERSION.SDK_INT >= 19) {
            this.nC.removeTouchExplorationStateChangeListener(this.SUi);
        }
        this.aFp.unregisterContentObserver(this.SUj);
        this.SNY.a(null);
        AppMethodBeat.o(9751);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0392 A[LOOP:0: B:197:0x038c->B:199:0x0392, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01be  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r11) {
        /*
        // Method dump skipped, instructions count: 1188
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.a.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public final boolean performAction(int i2, int i3, Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(9754);
        if (i2 >= 65536) {
            boolean performAction = this.STS.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.STX = null;
            }
            AppMethodBeat.o(9754);
            return performAction;
        }
        f fVar = this.STU.get(Integer.valueOf(i2));
        if (fVar == null) {
            AppMethodBeat.o(9754);
            return false;
        }
        switch (i3) {
            case 16:
                this.SNY.dispatchSemanticsAction(i2, b.TAP);
                AppMethodBeat.o(9754);
                return true;
            case 32:
                this.SNY.dispatchSemanticsAction(i2, b.LONG_PRESS);
                AppMethodBeat.o(9754);
                return true;
            case 64:
                this.SNY.dispatchSemanticsAction(i2, b.DID_GAIN_ACCESSIBILITY_FOCUS);
                mU(i2, 32768);
                if (this.STW == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.STW = fVar;
                if (fVar.a(b.INCREASE) || fVar.a(b.DECREASE)) {
                    mU(i2, 4);
                }
                AppMethodBeat.o(9754);
                return true;
            case 128:
                this.SNY.dispatchSemanticsAction(i2, b.DID_LOSE_ACCESSIBILITY_FOCUS);
                mU(i2, 65536);
                this.STW = null;
                this.STX = null;
                AppMethodBeat.o(9754);
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    AppMethodBeat.o(9754);
                    return false;
                }
                boolean a2 = a(fVar, i2, bundle, true);
                AppMethodBeat.o(9754);
                return a2;
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    AppMethodBeat.o(9754);
                    return false;
                }
                boolean a3 = a(fVar, i2, bundle, false);
                AppMethodBeat.o(9754);
                return a3;
            case 4096:
                if (fVar.a(b.SCROLL_UP)) {
                    this.SNY.dispatchSemanticsAction(i2, b.SCROLL_UP);
                } else if (fVar.a(b.SCROLL_LEFT)) {
                    this.SNY.dispatchSemanticsAction(i2, b.SCROLL_LEFT);
                } else if (fVar.a(b.INCREASE)) {
                    fVar.value = fVar.SVw;
                    mU(i2, 4);
                    this.SNY.dispatchSemanticsAction(i2, b.INCREASE);
                } else {
                    AppMethodBeat.o(9754);
                    return false;
                }
                AppMethodBeat.o(9754);
                return true;
            case 8192:
                if (fVar.a(b.SCROLL_DOWN)) {
                    this.SNY.dispatchSemanticsAction(i2, b.SCROLL_DOWN);
                } else if (fVar.a(b.SCROLL_RIGHT)) {
                    this.SNY.dispatchSemanticsAction(i2, b.SCROLL_RIGHT);
                } else if (fVar.a(b.DECREASE)) {
                    fVar.value = fVar.SVx;
                    mU(i2, 4);
                    this.SNY.dispatchSemanticsAction(i2, b.DECREASE);
                } else {
                    AppMethodBeat.o(9754);
                    return false;
                }
                AppMethodBeat.o(9754);
                return true;
            case 16384:
                this.SNY.dispatchSemanticsAction(i2, b.COPY);
                AppMethodBeat.o(9754);
                return true;
            case 32768:
                this.SNY.dispatchSemanticsAction(i2, b.PASTE);
                AppMethodBeat.o(9754);
                return true;
            case 65536:
                this.SNY.dispatchSemanticsAction(i2, b.CUT);
                AppMethodBeat.o(9754);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    AppMethodBeat.o(9754);
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z = true;
                }
                if (z) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                } else {
                    hashMap.put("base", Integer.valueOf(fVar.SVp));
                    hashMap.put("extent", Integer.valueOf(fVar.SVp));
                }
                this.SNY.dispatchSemanticsAction(i2, b.SET_SELECTION, hashMap);
                AppMethodBeat.o(9754);
                return true;
            case 1048576:
                this.SNY.dispatchSemanticsAction(i2, b.DISMISS);
                AppMethodBeat.o(9754);
                return true;
            case 16908342:
                this.SNY.dispatchSemanticsAction(i2, b.SHOW_ON_SCREEN);
                AppMethodBeat.o(9754);
                return true;
            default:
                c cVar = this.STV.get(Integer.valueOf(i3 - STR));
                if (cVar != null) {
                    this.SNY.dispatchSemanticsAction(i2, b.CUSTOM_ACTION, Integer.valueOf(cVar.id));
                    AppMethodBeat.o(9754);
                    return true;
                }
                AppMethodBeat.o(9754);
                return false;
        }
    }

    @TargetApi(18)
    private boolean a(f fVar, int i2, Bundle bundle, boolean z) {
        AppMethodBeat.i(9755);
        int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z2 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        switch (i3) {
            case 1:
                if (z && fVar.a(b.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                    this.SNY.dispatchSemanticsAction(i2, b.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(z2));
                    AppMethodBeat.o(9755);
                    return true;
                } else if (!z && fVar.a(b.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    this.SNY.dispatchSemanticsAction(i2, b.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(z2));
                    AppMethodBeat.o(9755);
                    return true;
                }
                break;
            case 2:
                if (z && fVar.a(b.MOVE_CURSOR_FORWARD_BY_WORD)) {
                    this.SNY.dispatchSemanticsAction(i2, b.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(z2));
                    AppMethodBeat.o(9755);
                    return true;
                } else if (!z && fVar.a(b.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    this.SNY.dispatchSemanticsAction(i2, b.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(z2));
                    AppMethodBeat.o(9755);
                    return true;
                }
                break;
        }
        AppMethodBeat.o(9755);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo findFocus(int r3) {
        /*
            r2 = this;
            r1 = 9756(0x261c, float:1.3671E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            switch(r3) {
                case 1: goto L_0x000d;
                case 2: goto L_0x002f;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
        L_0x000c:
            return r0
        L_0x000d:
            io.flutter.view.a$f r0 = r2.SUa
            if (r0 == 0) goto L_0x001d
            io.flutter.view.a$f r0 = r2.SUa
            int r0 = r0.id
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.createAccessibilityNodeInfo(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000c
        L_0x001d:
            java.lang.Integer r0 = r2.STY
            if (r0 == 0) goto L_0x002f
            java.lang.Integer r0 = r2.STY
            int r0 = r0.intValue()
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.createAccessibilityNodeInfo(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000c
        L_0x002f:
            io.flutter.view.a$f r0 = r2.STW
            if (r0 == 0) goto L_0x003f
            io.flutter.view.a$f r0 = r2.STW
            int r0 = r0.id
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.createAccessibilityNodeInfo(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000c
        L_0x003f:
            java.lang.Integer r0 = r2.STX
            if (r0 == 0) goto L_0x0008
            java.lang.Integer r0 = r2.STX
            int r0 = r0.intValue()
            android.view.accessibility.AccessibilityNodeInfo r0 = r2.createAccessibilityNodeInfo(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000c
            switch-data {1->0x000d, 2->0x002f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.a.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* access modifiers changed from: package-private */
    public final f hxv() {
        AppMethodBeat.i(9757);
        f fVar = this.STU.get(0);
        AppMethodBeat.o(9757);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final f atF(int i2) {
        AppMethodBeat.i(9758);
        f fVar = this.STU.get(Integer.valueOf(i2));
        if (fVar == null) {
            fVar = new f(this);
            fVar.id = i2;
            this.STU.put(Integer.valueOf(i2), fVar);
        }
        AppMethodBeat.o(9758);
        return fVar;
    }

    /* access modifiers changed from: package-private */
    public final c atG(int i2) {
        AppMethodBeat.i(9759);
        c cVar = this.STV.get(Integer.valueOf(i2));
        if (cVar == null) {
            cVar = new c();
            cVar.id = i2;
            cVar.resourceId = STR + i2;
            this.STV.put(Integer.valueOf(i2), cVar);
        }
        AppMethodBeat.o(9759);
        return cVar;
    }

    public final boolean aE(MotionEvent motionEvent) {
        AppMethodBeat.i(9760);
        if (!this.nC.isTouchExplorationEnabled()) {
            AppMethodBeat.o(9760);
            return false;
        } else if (this.STU.isEmpty()) {
            AppMethodBeat.o(9760);
            return false;
        } else {
            f r = hxv().r(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
            if (r == null || r.SVq == -1) {
                if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                    aH(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 10) {
                    hxw();
                } else {
                    new StringBuilder("unexpected accessibility hover event: ").append(motionEvent);
                    AppMethodBeat.o(9760);
                    return false;
                }
                AppMethodBeat.o(9760);
                return true;
            }
            boolean onAccessibilityHoverEvent = this.STS.onAccessibilityHoverEvent(r.id, motionEvent);
            AppMethodBeat.o(9760);
            return onAccessibilityHoverEvent;
        }
    }

    private void hxw() {
        AppMethodBeat.i(9761);
        if (this.SUc != null) {
            mU(this.SUc.id, 256);
            this.SUc = null;
        }
        AppMethodBeat.o(9761);
    }

    private void aH(float f2, float f3) {
        AppMethodBeat.i(9762);
        if (this.STU.isEmpty()) {
            AppMethodBeat.o(9762);
            return;
        }
        f r = hxv().r(new float[]{f2, f3, 0.0f, 1.0f});
        if (r != this.SUc) {
            if (r != null) {
                mU(r.id, 128);
            }
            if (this.SUc != null) {
                mU(this.SUc.id, 256);
            }
            this.SUc = r;
        }
        AppMethodBeat.o(9762);
    }

    /* access modifiers changed from: package-private */
    public final AccessibilityEvent ae(int i2, String str, String str2) {
        AppMethodBeat.i(9763);
        AccessibilityEvent mV = mV(i2, 16);
        mV.setBeforeText(str);
        mV.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 < str.length() || i3 < str2.length()) {
            mV.setFromIndex(i3);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            mV.setRemovedCount((length - i3) + 1);
            mV.setAddedCount((length2 - i3) + 1);
            AppMethodBeat.o(9763);
            return mV;
        }
        AppMethodBeat.o(9763);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void mU(int i2, int i3) {
        AppMethodBeat.i(9764);
        if (!this.nC.isEnabled()) {
            AppMethodBeat.o(9764);
            return;
        }
        sendAccessibilityEvent(mV(i2, i3));
        AppMethodBeat.o(9764);
    }

    /* access modifiers changed from: package-private */
    public final void sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(9765);
        if (!this.nC.isEnabled()) {
            AppMethodBeat.o(9765);
            return;
        }
        this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        AppMethodBeat.o(9765);
    }

    /* access modifiers changed from: package-private */
    public final void atH(int i2) {
        AppMethodBeat.i(214927);
        AccessibilityEvent mV = mV(i2, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            mV.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(mV);
        AppMethodBeat.o(214927);
    }

    /* access modifiers changed from: package-private */
    public final AccessibilityEvent mV(int i2, int i3) {
        AppMethodBeat.i(9766);
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i2);
        AppMethodBeat.o(9766);
        return obtain;
    }

    public final void reset() {
        AppMethodBeat.i(9767);
        this.STU.clear();
        if (this.STW != null) {
            mU(this.STW.id, 65536);
        }
        this.STW = null;
        this.SUc = null;
        atH(0);
        AppMethodBeat.o(9767);
    }

    public enum b {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(TPMediaCodecProfileLevel.HEVCMainTierLevel52),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576);
        
        public final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(9782);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(9782);
            return bVar;
        }

        static {
            AppMethodBeat.i(9783);
            AppMethodBeat.o(9783);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public enum d {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(TPMediaCodecProfileLevel.HEVCMainTierLevel52),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(TPMediaCodecProfileLevel.HEVCHighTierLevel6),
        IS_LINK(4194304);
        
        final int value;

        public static d valueOf(String str) {
            AppMethodBeat.i(9678);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(9678);
            return dVar;
        }

        static {
            AppMethodBeat.i(9679);
            AppMethodBeat.o(9679);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.view.a$a  reason: collision with other inner class name */
    public enum EnumC2255a {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int value;

        public static EnumC2255a valueOf(String str) {
            AppMethodBeat.i(9823);
            EnumC2255a aVar = (EnumC2255a) Enum.valueOf(EnumC2255a.class, str);
            AppMethodBeat.o(9823);
            return aVar;
        }

        static {
            AppMethodBeat.i(9824);
            AppMethodBeat.o(9824);
        }

        private EnumC2255a(int i2) {
            this.value = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public enum g {
        UNKNOWN,
        LTR,
        RTL;

        public static g valueOf(String str) {
            AppMethodBeat.i(9686);
            g gVar = (g) Enum.valueOf(g.class, str);
            AppMethodBeat.o(9686);
            return gVar;
        }

        static {
            AppMethodBeat.i(9687);
            AppMethodBeat.o(9687);
        }

        public static g atI(int i2) {
            switch (i2) {
                case 1:
                    return RTL;
                case 2:
                    return LTR;
                default:
                    return UNKNOWN;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        int SUN = -1;
        String hint;
        int id = -1;
        String label;
        int resourceId = -1;

        c() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class f {
        final a SNs;
        private int SVA;
        private int SVB;
        int SVC;
        int SVD;
        float SVE;
        private float SVF;
        private float SVG;
        String SVH;
        String SVI;
        f SVJ;
        List<f> SVK = new ArrayList();
        List<f> SVL = new ArrayList();
        List<c> SVM;
        c SVN;
        c SVO;
        boolean SVP = true;
        private float[] SVQ;
        boolean SVR = true;
        private float[] SVS;
        Rect SVT;
        int SVl;
        int SVm;
        int SVn;
        int SVo;
        int SVp;
        int SVq;
        int SVr;
        int SVs;
        float SVt;
        float SVu;
        float SVv;
        String SVw;
        String SVx;
        private g SVy;
        boolean SVz = false;
        private float bottom;
        int flags;
        String hint;
        int id = -1;
        String label;
        private float left;
        private float right;
        private float top;
        private float[] transform;
        String value;

        static /* synthetic */ String b(f fVar) {
            AppMethodBeat.i(214924);
            String hxy = fVar.hxy();
            AppMethodBeat.o(214924);
            return hxy;
        }

        static boolean a(f fVar, io.flutter.a.c<f> cVar) {
            AppMethodBeat.i(9802);
            if (fVar != null) {
                f fVar2 = fVar.SVJ;
                while (true) {
                    if (fVar2 == null) {
                        fVar2 = null;
                        break;
                    } else if (cVar.test(fVar2)) {
                        break;
                    } else {
                        fVar2 = fVar2.SVJ;
                    }
                }
                if (fVar2 != null) {
                    AppMethodBeat.o(9802);
                    return true;
                }
            }
            AppMethodBeat.o(9802);
            return false;
        }

        f(a aVar) {
            AppMethodBeat.i(9803);
            this.SNs = aVar;
            AppMethodBeat.o(9803);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(b bVar) {
            return (this.SVl & bVar.value) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean b(b bVar) {
            return (this.SVB & bVar.value) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(d dVar) {
            return (this.flags & dVar.value) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean b(d dVar) {
            return (this.SVA & dVar.value) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void a(ByteBuffer byteBuffer, String[] strArr) {
            AppMethodBeat.i(9804);
            this.SVz = true;
            this.SVH = this.value;
            this.SVI = this.label;
            this.SVA = this.flags;
            this.SVB = this.SVl;
            this.SVC = this.SVo;
            this.SVD = this.SVp;
            this.SVE = this.SVt;
            this.SVF = this.SVu;
            this.SVG = this.SVv;
            this.flags = byteBuffer.getInt();
            this.SVl = byteBuffer.getInt();
            this.SVm = byteBuffer.getInt();
            this.SVn = byteBuffer.getInt();
            this.SVo = byteBuffer.getInt();
            this.SVp = byteBuffer.getInt();
            this.SVq = byteBuffer.getInt();
            this.SVr = byteBuffer.getInt();
            this.SVs = byteBuffer.getInt();
            this.SVt = byteBuffer.getFloat();
            this.SVu = byteBuffer.getFloat();
            this.SVv = byteBuffer.getFloat();
            int i2 = byteBuffer.getInt();
            this.label = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            this.value = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            this.SVw = i4 == -1 ? null : strArr[i4];
            int i5 = byteBuffer.getInt();
            this.SVx = i5 == -1 ? null : strArr[i5];
            int i6 = byteBuffer.getInt();
            this.hint = i6 == -1 ? null : strArr[i6];
            this.SVy = g.atI(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i7 = 0; i7 < 16; i7++) {
                this.transform[i7] = byteBuffer.getFloat();
            }
            this.SVP = true;
            this.SVR = true;
            int i8 = byteBuffer.getInt();
            this.SVK.clear();
            this.SVL.clear();
            for (int i9 = 0; i9 < i8; i9++) {
                f b2 = a.b(this.SNs, byteBuffer.getInt());
                b2.SVJ = this;
                this.SVK.add(b2);
            }
            for (int i10 = 0; i10 < i8; i10++) {
                f b3 = a.b(this.SNs, byteBuffer.getInt());
                b3.SVJ = this;
                this.SVL.add(b3);
            }
            int i11 = byteBuffer.getInt();
            if (i11 == 0) {
                this.SVM = null;
                AppMethodBeat.o(9804);
                return;
            }
            if (this.SVM == null) {
                this.SVM = new ArrayList(i11);
            } else {
                this.SVM.clear();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                c c2 = a.c(this.SNs, byteBuffer.getInt());
                if (c2.SUN == b.TAP.value) {
                    this.SVN = c2;
                } else if (c2.SUN == b.LONG_PRESS.value) {
                    this.SVO = c2;
                } else {
                    this.SVM.add(c2);
                }
                this.SVM.add(c2);
            }
            AppMethodBeat.o(9804);
        }

        /* access modifiers changed from: package-private */
        public final f r(float[] fArr) {
            AppMethodBeat.i(9805);
            float f2 = fArr[3];
            float f3 = fArr[0] / f2;
            float f4 = fArr[1] / f2;
            if (f3 < this.left || f3 >= this.right || f4 < this.top || f4 >= this.bottom) {
                AppMethodBeat.o(9805);
                return null;
            }
            float[] fArr2 = new float[4];
            for (f fVar : this.SVL) {
                if (!fVar.a(d.IS_HIDDEN)) {
                    if (fVar.SVP) {
                        fVar.SVP = false;
                        if (fVar.SVQ == null) {
                            fVar.SVQ = new float[16];
                        }
                        if (!Matrix.invertM(fVar.SVQ, 0, fVar.transform, 0)) {
                            Arrays.fill(fVar.SVQ, 0.0f);
                        }
                    }
                    Matrix.multiplyMV(fArr2, 0, fVar.SVQ, 0, fArr, 0);
                    f r = fVar.r(fArr2);
                    if (r != null) {
                        AppMethodBeat.o(9805);
                        return r;
                    }
                }
            }
            AppMethodBeat.o(9805);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void kp(List<f> list) {
            AppMethodBeat.i(9806);
            if (a(d.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (f fVar : this.SVK) {
                fVar.kp(list);
            }
            AppMethodBeat.o(9806);
        }

        /* access modifiers changed from: package-private */
        public final String hxx() {
            AppMethodBeat.i(9807);
            if (!a(d.NAMES_ROUTE) || this.label == null || this.label.isEmpty()) {
                for (f fVar : this.SVK) {
                    String hxx = fVar.hxx();
                    if (!(hxx == null || hxx.isEmpty())) {
                        AppMethodBeat.o(9807);
                        return hxx;
                    }
                }
                AppMethodBeat.o(9807);
                return null;
            }
            String str = this.label;
            AppMethodBeat.o(9807);
            return str;
        }

        /* access modifiers changed from: package-private */
        public final void a(float[] fArr, Set<f> set, boolean z) {
            AppMethodBeat.i(9808);
            set.add(this);
            if (this.SVR) {
                z = true;
            }
            if (z) {
                if (this.SVS == null) {
                    this.SVS = new float[16];
                }
                Matrix.multiplyMM(this.SVS, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = new float[4];
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                fArr2[0] = this.left;
                fArr2[1] = this.top;
                c(fArr3, this.SVS, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                c(fArr4, this.SVS, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                c(fArr5, this.SVS, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                c(fArr6, this.SVS, fArr2);
                if (this.SVT == null) {
                    this.SVT = new Rect();
                }
                this.SVT.set(Math.round(t(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(t(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(d(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(d(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.SVR = false;
            }
            for (f fVar : this.SVK) {
                fVar.a(this.SVS, set, z);
            }
            AppMethodBeat.o(9808);
        }

        private static void c(float[] fArr, float[] fArr2, float[] fArr3) {
            AppMethodBeat.i(9809);
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f2 = fArr[3];
            fArr[0] = fArr[0] / f2;
            fArr[1] = fArr[1] / f2;
            fArr[2] = fArr[2] / f2;
            fArr[3] = 0.0f;
            AppMethodBeat.o(9809);
        }

        private static float t(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(9810);
            float min = Math.min(f2, Math.min(f3, Math.min(f4, f5)));
            AppMethodBeat.o(9810);
            return min;
        }

        private static float d(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(9811);
            float max = Math.max(f2, Math.max(f3, Math.max(f4, f5)));
            AppMethodBeat.o(9811);
            return max;
        }

        private String hxy() {
            AppMethodBeat.i(9812);
            StringBuilder sb = new StringBuilder();
            String[] strArr = {this.value, this.label, this.hint};
            for (int i2 = 0; i2 < 3; i2++) {
                String str = strArr[i2];
                if (str != null && str.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(str);
                }
            }
            if (sb.length() > 0) {
                String sb2 = sb.toString();
                AppMethodBeat.o(9812);
                return sb2;
            }
            AppMethodBeat.o(9812);
            return null;
        }
    }

    private boolean a(final f fVar) {
        AppMethodBeat.i(9752);
        if (fVar.SVr <= 0 || (!f.a(this.STW, new io.flutter.a.c<f>() {
            /* class io.flutter.view.a.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.flutter.a.c
            public final /* bridge */ /* synthetic */ boolean test(f fVar) {
                return fVar == fVar;
            }
        }) && f.a(this.STW, new io.flutter.a.c<f>() {
            /* class io.flutter.view.a.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.flutter.a.c
            public final /* synthetic */ boolean test(f fVar) {
                AppMethodBeat.i(9828);
                boolean a2 = fVar.a(d.HAS_IMPLICIT_SCROLLING);
                AppMethodBeat.o(9828);
                return a2;
            }
        }))) {
            AppMethodBeat.o(9752);
            return false;
        }
        AppMethodBeat.o(9752);
        return true;
    }

    static /* synthetic */ void j(a aVar) {
        AppMethodBeat.i(9771);
        io.flutter.embedding.engine.c.a aVar2 = aVar.SNY;
        aVar2.SNV.setAccessibilityFeatures(aVar.STZ);
        AppMethodBeat.o(9771);
    }
}
