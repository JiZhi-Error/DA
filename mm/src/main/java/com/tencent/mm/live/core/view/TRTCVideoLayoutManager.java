package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TRTCVideoLayoutManager extends RelativeLayout implements b.AbstractC0390b {
    private static final String TAG = TRTCVideoLayoutManager.class.getSimpleName();
    public WeakReference<a> hAW;
    private ArrayList<RelativeLayout.LayoutParams> hFs;
    private ArrayList<RelativeLayout.LayoutParams> hFt;
    private ArrayList<RelativeLayout.LayoutParams> hFu;
    private String hFv;
    private String hFw;
    private int mCount = 0;
    private int mMode;
    private List<b> vad;

    public interface a {
    }

    static {
        AppMethodBeat.i(196371);
        AppMethodBeat.o(196371);
    }

    public TRTCVideoLayoutManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(196338);
        bh(context);
        AppMethodBeat.o(196338);
    }

    public TRTCVideoLayoutManager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(196339);
        bh(context);
        AppMethodBeat.o(196339);
    }

    private void bh(Context context) {
        AppMethodBeat.i(196340);
        Log.i(TAG, "initView: ");
        this.vad = Collections.synchronizedList(new ArrayList());
        b bVar = new b(context, false);
        bVar.setVisibility(8);
        bVar.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bVar.hFk = false;
        bVar.setIVideoLayoutListener(this);
        bVar.setBottomControllerVisibility(8);
        b bVar2 = new b((byte) 0);
        bVar2.hFy = bVar;
        bVar2.index = 0;
        this.vad.add(bVar2);
        b bVar3 = new b(context, true);
        bVar3.setVisibility(8);
        bVar3.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bVar3.hFk = false;
        bVar3.setIVideoLayoutListener(this);
        bVar3.setBottomControllerVisibility(8);
        b bVar4 = new b((byte) 0);
        bVar4.hFy = bVar3;
        bVar4.index = 1;
        this.vad.add(bVar4);
        b bVar5 = new b(context, true);
        bVar5.setVisibility(8);
        bVar5.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bVar5.hFk = false;
        bVar5.setIVideoLayoutListener(this);
        bVar5.setBottomControllerVisibility(8);
        b bVar6 = new b((byte) 0);
        bVar6.hFy = bVar5;
        bVar6.index = 2;
        this.vad.add(bVar6);
        b bVar7 = new b(context, true);
        bVar7.setVisibility(8);
        bVar7.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bVar7.hFk = false;
        bVar7.setIVideoLayoutListener(this);
        bVar7.setBottomControllerVisibility(8);
        b bVar8 = new b((byte) 0);
        bVar8.hFy = bVar7;
        bVar8.index = 3;
        this.vad.add(bVar8);
        this.mMode = 1;
        post(new Runnable() {
            /* class com.tencent.mm.live.core.view.TRTCVideoLayoutManager.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(196337);
                TRTCVideoLayoutManager.a(TRTCVideoLayoutManager.this);
                AppMethodBeat.o(196337);
            }
        });
        AppMethodBeat.o(196340);
    }

    @Override // com.tencent.mm.live.core.view.b.AbstractC0390b
    public final void g(b bVar) {
        AppMethodBeat.i(196341);
        if ((this.hAW != null ? this.hAW.get() : null) != null) {
            k(bVar);
        }
        AppMethodBeat.o(196341);
    }

    @Override // com.tencent.mm.live.core.view.b.AbstractC0390b
    public final void h(b bVar) {
        AppMethodBeat.i(196342);
        if ((this.hAW != null ? this.hAW.get() : null) != null) {
            k(bVar);
        }
        AppMethodBeat.o(196342);
    }

    @Override // com.tencent.mm.live.core.view.b.AbstractC0390b
    public final void i(b bVar) {
        AppMethodBeat.i(196343);
        if ((this.hAW != null ? this.hAW.get() : null) != null) {
            k(bVar);
        }
        AppMethodBeat.o(196343);
    }

    @Override // com.tencent.mm.live.core.view.b.AbstractC0390b
    public final void j(b bVar) {
        AppMethodBeat.i(196344);
        if ((this.hAW != null ? this.hAW.get() : null) != null) {
            k(bVar);
        }
        AppMethodBeat.o(196344);
    }

    public void setIVideoLayoutListener(a aVar) {
        AppMethodBeat.i(196345);
        if (aVar == null) {
            this.hAW = null;
            AppMethodBeat.o(196345);
            return;
        }
        this.hAW = new WeakReference<>(aVar);
        AppMethodBeat.o(196345);
    }

    public void setMySelfUserId(String str) {
        this.hFv = str;
    }

    public void setPkUserId(String str) {
        this.hFw = str;
    }

    public final b GG(String str) {
        AppMethodBeat.i(196346);
        if (str == null) {
            AppMethodBeat.o(196346);
            return null;
        }
        for (b bVar : this.vad) {
            if (bVar.streamType == 0 && bVar.userId.equals(str)) {
                b bVar2 = bVar.hFy;
                AppMethodBeat.o(196346);
                return bVar2;
            }
        }
        AppMethodBeat.o(196346);
        return null;
    }

    public final TXCloudVideoView Y(String str, int i2) {
        AppMethodBeat.i(196347);
        if (str == null) {
            AppMethodBeat.o(196347);
            return null;
        }
        for (b bVar : this.vad) {
            if (bVar.hFy.mVideoView != null && (("".equals(bVar.userId) && bVar.streamType == -1) || (Util.isEqual(str, bVar.userId) && bVar.streamType == i2))) {
                bVar.userId = str;
                bVar.streamType = i2;
                bVar.hFy.setVisibility(0);
                this.mCount++;
                if (this.mMode == 2 && this.mCount == 5) {
                    aFc();
                }
                bVar.hFy.GF("");
                TXCloudVideoView tXCloudVideoView = bVar.hFy.mVideoView;
                AppMethodBeat.o(196347);
                return tXCloudVideoView;
            }
        }
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
            Log.printInfoStack(TAG, "allocCloudVideoView userId ".concat(String.valueOf(str)), new Object[0]);
            u.makeText(MMApplicationContext.getContext(), "allocCloudVideoView userId ".concat(String.valueOf(str)), 0).show();
        }
        Log.e(TAG, "allocCloudVideoView userId ".concat(String.valueOf(str)));
        AppMethodBeat.o(196347);
        return null;
    }

    public final SurfaceView aEX() {
        AppMethodBeat.i(196348);
        for (b bVar : this.vad) {
            if (bVar.hFy.hEY != null) {
                bVar.userId = "";
                bVar.streamType = 0;
                bVar.hFy.setVisibility(0);
                this.mCount++;
                if (this.mMode == 2 && this.mCount == 5) {
                    aFc();
                }
                bVar.hFy.GF("");
                SurfaceView surfaceView = bVar.hFy.hEY;
                AppMethodBeat.o(196348);
                return surfaceView;
            }
        }
        AppMethodBeat.o(196348);
        return null;
    }

    public int getCameraViewWidth() {
        AppMethodBeat.i(196349);
        for (b bVar : this.vad) {
            if (bVar.hFy.hEY != null) {
                if (bVar.hFy.getLayoutParams() == null) {
                    AppMethodBeat.o(196349);
                    return -1;
                }
                int i2 = bVar.hFy.getLayoutParams().width;
                AppMethodBeat.o(196349);
                return i2;
            }
        }
        AppMethodBeat.o(196349);
        return -1;
    }

    public int getCameraViewHeight() {
        AppMethodBeat.i(196350);
        for (b bVar : this.vad) {
            if (bVar.hFy.hEY != null) {
                if (bVar.hFy.getLayoutParams() == null) {
                    AppMethodBeat.o(196350);
                    return -1;
                }
                int i2 = bVar.hFy.getLayoutParams().height;
                AppMethodBeat.o(196350);
                return i2;
            }
        }
        AppMethodBeat.o(196350);
        return -1;
    }

    public final void GH(String str) {
        AppMethodBeat.i(196351);
        if (str == null) {
            AppMethodBeat.o(196351);
            return;
        }
        if (this.mMode == 1) {
            b bVar = this.vad.get(0);
            if (str.equals(bVar.userId) && bVar.streamType == 0) {
                qP(1);
            }
        }
        for (b bVar2 : this.vad) {
            if (bVar2.streamType == 0 && str.equals(bVar2.userId)) {
                this.mCount--;
                if (this.mMode == 2 && this.mCount == 4) {
                    aFc();
                }
                b bVar3 = bVar2.hFy;
                Context context = getContext();
                int width = getWidth();
                getHeight();
                bVar3.setLayoutParams(c.I(context, width));
                bVar2.hFy.setVisibility(8);
                bVar2.userId = "";
                bVar2.streamType = -1;
                AppMethodBeat.o(196351);
                return;
            }
        }
        AppMethodBeat.o(196351);
    }

    public final void aEY() {
        AppMethodBeat.i(196352);
        for (b bVar : this.vad) {
            if (bVar.hFy.hEY != null) {
                if (bVar.index == 0) {
                    qP(1);
                }
                this.mCount--;
                if (this.mMode == 2 && this.mCount == 4) {
                    aFc();
                }
                b bVar2 = bVar.hFy;
                Context context = getContext();
                int width = getWidth();
                getHeight();
                bVar2.setLayoutParams(c.I(context, width));
                bVar.hFy.setVisibility(8);
                bVar.userId = "";
                bVar.streamType = -1;
            }
        }
        AppMethodBeat.o(196352);
    }

    public final void aEZ() {
        AppMethodBeat.i(196353);
        for (b bVar : this.vad) {
            if (!(bVar.hFy.mVideoView == null || bVar.hFy.getParent() == null || !(bVar.hFy.getParent() instanceof ViewGroup))) {
                ViewGroup viewGroup = (ViewGroup) bVar.hFy.getParent();
                viewGroup.removeView(bVar.hFy);
                viewGroup.addView(bVar.hFy);
            }
        }
        AppMethodBeat.o(196353);
    }

    public final void aFa() {
        AppMethodBeat.i(196354);
        for (b bVar : this.vad) {
            if (!(bVar.hFy.hEY == null || bVar.hFy.getParent() == null || !(bVar.hFy.getParent() instanceof ViewGroup))) {
                ViewGroup viewGroup = (ViewGroup) bVar.hFy.getParent();
                viewGroup.removeView(bVar.hFy);
                viewGroup.addView(bVar.hFy);
            }
        }
        AppMethodBeat.o(196354);
    }

    private b k(b bVar) {
        AppMethodBeat.i(196355);
        for (b bVar2 : this.vad) {
            if (bVar2.hFy == bVar) {
                AppMethodBeat.o(196355);
                return bVar2;
            }
        }
        AppMethodBeat.o(196355);
        return null;
    }

    private b GI(String str) {
        AppMethodBeat.i(196356);
        Log.i(TAG, "findEntity userId:".concat(String.valueOf(str)));
        for (b bVar : this.vad) {
            if (bVar.userId.equals(str)) {
                AppMethodBeat.o(196356);
                return bVar;
            }
        }
        AppMethodBeat.o(196356);
        return null;
    }

    private void aFc() {
        ArrayList<RelativeLayout.LayoutParams> arrayList;
        AppMethodBeat.i(196358);
        if (this.hFt == null || this.hFt.size() == 0 || this.hFu == null || this.hFu.size() == 0) {
            this.hFt = c.b(getContext(), getWidth(), getHeight());
            this.hFu = c.c(getContext(), getWidth(), getHeight());
        }
        if (this.mCount <= 4) {
            arrayList = this.hFt;
        } else {
            arrayList = this.hFu;
        }
        int i2 = 1;
        for (int i3 = 0; i3 < this.vad.size(); i3++) {
            b bVar = this.vad.get(i3);
            bVar.hFy.hFk = false;
            bVar.hFy.setOnClickListener(null);
            if (bVar.userId.equals(this.hFv)) {
                bVar.hFy.setLayoutParams(arrayList.get(0));
            } else if (i2 < arrayList.size()) {
                bVar.hFy.setLayoutParams(arrayList.get(i2));
                i2++;
            }
        }
        AppMethodBeat.o(196358);
    }

    public final void qP(int i2) {
        AppMethodBeat.i(196359);
        if (i2 <= 0 || this.vad.size() <= i2) {
            AppMethodBeat.o(196359);
            return;
        }
        Log.i(TAG, "makeFullVideoView: from = ".concat(String.valueOf(i2)));
        b bVar = this.vad.get(i2);
        ViewGroup.LayoutParams layoutParams = bVar.hFy.getLayoutParams();
        b bVar2 = this.vad.get(0);
        bVar.hFy.setLayoutParams(bVar2.hFy.getLayoutParams());
        bVar.index = 0;
        bVar2.hFy.setLayoutParams(layoutParams);
        bVar2.index = i2;
        bVar.hFy.hFk = false;
        bVar.hFy.setOnClickListener(null);
        bVar2.hFy.hFk = true;
        this.vad.set(0, bVar);
        this.vad.set(i2, bVar2);
        for (int i3 = 0; i3 < this.vad.size(); i3++) {
            bringChildToFront(this.vad.get(i3).hFy);
        }
        AppMethodBeat.o(196359);
    }

    public final void hF(List<String> list) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(261585);
        if (list == null || list.size() == 0) {
            Log.w(TAG, "halfCameraAndRemote return by invalid value!");
            AppMethodBeat.o(261585);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (i2 != 0 && GI(str) == null) {
                Y(str, 0);
            }
            Log.i(TAG, "checkAnchorRemoteView userId:" + str + " i:" + i2);
        }
        switch (list.size()) {
            case 1:
                b bVar = (b) getCameraContentView();
                if (!(bVar == null || bVar.getLayoutParams() == null)) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.getLayoutParams();
                    layoutParams2.width = -1;
                    layoutParams2.height = -1;
                    layoutParams2.setMarginStart(0);
                    layoutParams2.setMarginEnd(0);
                    bVar.bringToFront();
                    bVar.setLayoutParams(layoutParams2);
                    bVar.hFk = false;
                    bVar.setOnClickListener(null);
                    for (int i3 = 0; i3 < this.vad.size(); i3++) {
                        b bVar2 = this.vad.get(i3);
                        if (!(bVar2 == null || (layoutParams = (RelativeLayout.LayoutParams) bVar2.hFy.getLayoutParams()) == null)) {
                            layoutParams.width = -1;
                            layoutParams.height = -1;
                            layoutParams.setMarginStart(0);
                            layoutParams.setMarginEnd(0);
                            bVar2.hFy.setLayoutParams(layoutParams);
                        }
                    }
                    break;
                }
            case 2:
                String str2 = list.get(1);
                Log.i(TAG, "cameraAndRemote userId:".concat(String.valueOf(str2)));
                if (str2 != null && str2.length() != 0) {
                    b bVar3 = (b) getCameraContentView();
                    if (!(bVar3 == null || bVar3.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar3.getLayoutParams();
                        layoutParams3.width = au.az(getContext()).x / 2;
                        layoutParams3.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                        layoutParams3.setMarginStart(0);
                        layoutParams3.setMarginEnd(0);
                        bVar3.setLayoutParams(layoutParams3);
                        bVar3.hFk = false;
                        bVar3.setOnClickListener(null);
                        bVar3.bringToFront();
                    }
                    b GI = GI(str2);
                    if (!(GI == null || GI.hFy == null || GI.hFy.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) GI.hFy.getLayoutParams();
                        layoutParams4.width = au.az(getContext()).x / 2;
                        layoutParams4.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                        layoutParams4.setMarginStart(au.az(getContext()).x / 2);
                        layoutParams4.setMarginEnd(0);
                        layoutParams4.topMargin = 0;
                        layoutParams4.bottomMargin = 0;
                        GI.hFy.setLayoutParams(layoutParams4);
                        GI.hFy.hFk = false;
                        GI.hFy.setOnClickListener(null);
                        GI.hFy.bringToFront();
                        break;
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case2 return by invalid value!");
                    break;
                }
                break;
            case 3:
                String str3 = list.get(1);
                Log.i(TAG, "cameraAnd2Remote userId1:".concat(String.valueOf(str3)));
                if (str3 != null && str3.length() != 0) {
                    b bVar4 = (b) getCameraContentView();
                    if (!(bVar4 == null || bVar4.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) bVar4.getLayoutParams();
                        layoutParams5.width = au.az(getContext()).x / 2;
                        layoutParams5.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                        layoutParams5.setMarginStart(0);
                        layoutParams5.setMarginEnd(0);
                        bVar4.setLayoutParams(layoutParams5);
                        bVar4.hFk = false;
                        bVar4.setOnClickListener(null);
                        bVar4.bringToFront();
                    }
                    b GI2 = GI(str3);
                    if (!(GI2 == null || GI2.hFy == null || GI2.hFy.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) GI2.hFy.getLayoutParams();
                        layoutParams6.width = au.az(getContext()).x / 2;
                        layoutParams6.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                        layoutParams6.setMarginStart(au.az(getContext()).x / 2);
                        layoutParams6.setMarginEnd(0);
                        layoutParams6.topMargin = 0;
                        layoutParams6.bottomMargin = 0;
                        GI2.hFy.setLayoutParams(layoutParams6);
                        GI2.hFy.hFk = false;
                        GI2.hFy.setOnClickListener(null);
                        GI2.hFy.bringToFront();
                    }
                    String str4 = list.get(2);
                    Log.i(TAG, "cameraAnd2Remote userId2:".concat(String.valueOf(str4)));
                    if (str4 != null && str4.length() != 0) {
                        b GI3 = GI(str4);
                        if (!(GI3 == null || GI3.hFy == null || GI3.hFy.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) GI3.hFy.getLayoutParams();
                            layoutParams7.width = au.az(getContext()).x / 2;
                            layoutParams7.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams7.setMarginStart(au.az(getContext()).x / 2);
                            layoutParams7.setMarginEnd(0);
                            layoutParams7.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams7.bottomMargin = 0;
                            GI3.hFy.setLayoutParams(layoutParams7);
                            GI3.hFy.hFk = false;
                            GI3.hFy.setOnClickListener(null);
                            GI3.hFy.bringToFront();
                            break;
                        }
                    } else {
                        Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
                        break;
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
                    break;
                }
                break;
            case 4:
                String str5 = list.get(1);
                Log.i(TAG, "cameraAnd3Remote userId1:".concat(String.valueOf(str5)));
                if (str5 != null && str5.length() != 0) {
                    b bVar5 = (b) getCameraContentView();
                    if (!(bVar5 == null || bVar5.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) bVar5.getLayoutParams();
                        layoutParams8.width = au.az(getContext()).x / 2;
                        layoutParams8.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                        layoutParams8.setMarginStart(0);
                        layoutParams8.setMarginEnd(0);
                        bVar5.setLayoutParams(layoutParams8);
                        bVar5.hFk = false;
                        bVar5.setOnClickListener(null);
                        bVar5.bringToFront();
                    }
                    b GI4 = GI(str5);
                    if (GI4 == null || GI4.hFy == null || GI4.hFy.getLayoutParams() == null) {
                        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
                            u.makeText(MMApplicationContext.getContext(), "pkEntity1 is nul", 0).show();
                        }
                        Log.e(TAG, "pkEntity1 is null");
                    } else {
                        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) GI4.hFy.getLayoutParams();
                        layoutParams9.width = au.az(getContext()).x / 2;
                        layoutParams9.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                        layoutParams9.setMarginStart(au.az(getContext()).x / 2);
                        layoutParams9.setMarginEnd(0);
                        layoutParams9.topMargin = 0;
                        layoutParams9.bottomMargin = 0;
                        GI4.hFy.setLayoutParams(layoutParams9);
                        GI4.hFy.hFk = false;
                        GI4.hFy.setOnClickListener(null);
                        GI4.hFy.bringToFront();
                    }
                    String str6 = list.get(2);
                    Log.i(TAG, "cameraAnd3Remote userId2:".concat(String.valueOf(str6)));
                    if (str6 != null && str6.length() != 0) {
                        b GI5 = GI(str6);
                        if (GI5 == null || GI5.hFy == null || GI5.hFy.getLayoutParams() == null) {
                            if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
                                u.makeText(MMApplicationContext.getContext(), "pkEntity2 is nul", 0).show();
                            }
                            Log.e(TAG, "pkEntity2 is null");
                        } else {
                            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) GI5.hFy.getLayoutParams();
                            layoutParams10.width = au.az(getContext()).x / 2;
                            layoutParams10.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams10.setMarginStart(0);
                            layoutParams10.setMarginEnd(0);
                            layoutParams10.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams10.bottomMargin = 0;
                            GI5.hFy.setLayoutParams(layoutParams10);
                            GI5.hFy.hFk = false;
                            GI5.hFy.setOnClickListener(null);
                            GI5.hFy.bringToFront();
                        }
                        String str7 = list.get(3);
                        Log.i(TAG, "cameraAnd3Remote userId3:".concat(String.valueOf(str7)));
                        if (str7 != null && str7.length() != 0) {
                            b GI6 = GI(str7);
                            if (GI6 != null && GI6.hFy != null && GI6.hFy.getLayoutParams() != null) {
                                RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) GI6.hFy.getLayoutParams();
                                layoutParams11.width = au.az(getContext()).x / 2;
                                layoutParams11.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams11.setMarginStart(au.az(getContext()).x / 2);
                                layoutParams11.setMarginEnd(0);
                                layoutParams11.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams11.bottomMargin = 0;
                                GI6.hFy.setLayoutParams(layoutParams11);
                                GI6.hFy.hFk = false;
                                GI6.hFy.setOnClickListener(null);
                                GI6.hFy.bringToFront();
                                break;
                            } else {
                                if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || CrashReportFactory.hasDebuger()) {
                                    u.makeText(MMApplicationContext.getContext(), "pkEntity3 is nul", 0).show();
                                }
                                Log.e(TAG, "pkEntity3 is null");
                                break;
                            }
                        } else {
                            Log.w(TAG, "halfCameraAndRemote case4 return by userId3 invalid value!");
                            break;
                        }
                    } else {
                        Log.w(TAG, "halfCameraAndRemote case3 return by userId2 invalid value!");
                        break;
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case3 return by userId1 invalid value!");
                    break;
                }
                break;
        }
        requestLayout();
        AppMethodBeat.o(261585);
    }

    public final void h(String str, String str2, List<String> list) {
        AppMethodBeat.i(261586);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || list == null || list.isEmpty()) {
            Log.w(TAG, "relayoutVisitorPreview return by invalid value!");
            AppMethodBeat.o(261586);
            return;
        }
        for (String str3 : list) {
            if (!Util.isEqual(str3, str2) && GI(str3) == null) {
                Y(str3, 0);
            }
            Log.i(TAG, "checkVisitorRemoteView userId:".concat(String.valueOf(str3)));
        }
        switch (list.size()) {
            case 1:
                Log.i(TAG, "relayoutVisitorPreview only anchor view");
                b GI = GI(str);
                if (!(GI == null || GI.hFy == null || GI.hFy.getLayoutParams() == null)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GI.hFy.getLayoutParams();
                    layoutParams.width = au.az(getContext()).x;
                    layoutParams.height = au.az(getContext()).y;
                    layoutParams.setMarginStart(0);
                    layoutParams.setMarginEnd(0);
                    GI.hFy.setLayoutParams(layoutParams);
                    GI.hFy.bringToFront();
                    break;
                }
            case 2:
                String str4 = list.get(1);
                Log.i(TAG, "remoteAndCamera anchorUserId:" + str + " selfId:" + str2 + " userId:" + str4);
                if (str4 != null && str4.length() != 0) {
                    b GI2 = GI(str);
                    if (!(GI2 == null || GI2.hFy == null || GI2.hFy.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) GI2.hFy.getLayoutParams();
                        layoutParams2.width = au.az(getContext()).x / 2;
                        layoutParams2.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                        layoutParams2.setMarginStart(0);
                        layoutParams2.setMarginEnd(0);
                        layoutParams2.topMargin = 0;
                        layoutParams2.bottomMargin = 0;
                        GI2.hFy.setLayoutParams(layoutParams2);
                        GI2.hFy.bringToFront();
                    }
                    if (Util.isEqual(str2, str4)) {
                        b bVar = (b) getCameraContentView();
                        if (!(bVar == null || bVar.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.getLayoutParams();
                            layoutParams3.width = au.az(getContext()).x / 2;
                            layoutParams3.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                            layoutParams3.topMargin = 0;
                            layoutParams3.bottomMargin = 0;
                            layoutParams3.setMarginStart(layoutParams3.width);
                            layoutParams3.setMarginEnd(0);
                            bVar.setLayoutParams(layoutParams3);
                            bVar.hFk = false;
                            bVar.setOnClickListener(null);
                            bVar.bringToFront();
                            break;
                        }
                    } else {
                        b GI3 = GI(str4);
                        if (!(GI3 == null || GI3.hFy == null || GI3.hFy.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) GI3.hFy.getLayoutParams();
                            layoutParams4.width = au.az(getContext()).x / 2;
                            layoutParams4.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                            layoutParams4.topMargin = 0;
                            layoutParams4.bottomMargin = 0;
                            layoutParams4.setMarginStart(layoutParams4.width);
                            layoutParams4.setMarginEnd(0);
                            GI3.hFy.setLayoutParams(layoutParams4);
                            GI3.hFy.hFk = false;
                            GI3.hFy.setOnClickListener(null);
                            GI3.hFy.bringToFront();
                            break;
                        }
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case2 return by invalid value!");
                    break;
                }
                break;
            case 3:
                String str5 = list.get(1);
                Log.i(TAG, "remoteAnd2Camera anchorUserId:" + str + " selfId:" + str2 + " userId1:" + str5);
                if (str5 != null && str5.length() != 0) {
                    b GI4 = GI(str);
                    if (!(GI4 == null || GI4.hFy == null || GI4.hFy.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) GI4.hFy.getLayoutParams();
                        layoutParams5.width = au.az(getContext()).x / 2;
                        layoutParams5.height = (int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f);
                        layoutParams5.setMarginStart(0);
                        layoutParams5.setMarginEnd(0);
                        layoutParams5.topMargin = 0;
                        layoutParams5.bottomMargin = 0;
                        GI4.hFy.setLayoutParams(layoutParams5);
                        GI4.hFy.bringToFront();
                    }
                    if (Util.isEqual(str2, str5)) {
                        b bVar2 = (b) getCameraContentView();
                        if (!(bVar2 == null || bVar2.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) bVar2.getLayoutParams();
                            layoutParams6.width = au.az(getContext()).x / 2;
                            layoutParams6.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams6.topMargin = 0;
                            layoutParams6.bottomMargin = 0;
                            layoutParams6.setMarginStart(layoutParams6.width);
                            layoutParams6.setMarginEnd(0);
                            bVar2.setLayoutParams(layoutParams6);
                            bVar2.hFk = false;
                            bVar2.setOnClickListener(null);
                            bVar2.bringToFront();
                        }
                    } else {
                        b GI5 = GI(str5);
                        if (!(GI5 == null || GI5.hFy == null || GI5.hFy.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) GI5.hFy.getLayoutParams();
                            layoutParams7.width = au.az(getContext()).x / 2;
                            layoutParams7.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams7.topMargin = 0;
                            layoutParams7.bottomMargin = 0;
                            layoutParams7.setMarginStart(layoutParams7.width);
                            layoutParams7.setMarginEnd(0);
                            GI5.hFy.setLayoutParams(layoutParams7);
                            GI5.hFy.hFk = false;
                            GI5.hFy.setOnClickListener(null);
                            GI5.hFy.bringToFront();
                        }
                    }
                    String str6 = list.get(2);
                    Log.i(TAG, "remoteAnd2Camera anchorUserId:" + str + " selfId:" + str2 + " userId2:" + str6);
                    if (str6 != null && str6.length() != 0) {
                        if (Util.isEqual(str2, str6)) {
                            b bVar3 = (b) getCameraContentView();
                            if (!(bVar3 == null || bVar3.getLayoutParams() == null)) {
                                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) bVar3.getLayoutParams();
                                layoutParams8.width = au.az(getContext()).x / 2;
                                layoutParams8.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams8.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams8.bottomMargin = 0;
                                layoutParams8.setMarginStart(layoutParams8.width);
                                layoutParams8.setMarginEnd(0);
                                bVar3.setLayoutParams(layoutParams8);
                                bVar3.hFk = false;
                                bVar3.setOnClickListener(null);
                                bVar3.bringToFront();
                                break;
                            }
                        } else {
                            b GI6 = GI(str6);
                            if (!(GI6 == null || GI6.hFy == null || GI6.hFy.getLayoutParams() == null)) {
                                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) GI6.hFy.getLayoutParams();
                                layoutParams9.width = au.az(getContext()).x / 2;
                                layoutParams9.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams9.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams9.bottomMargin = 0;
                                layoutParams9.setMarginStart(layoutParams9.width);
                                layoutParams9.setMarginEnd(0);
                                GI6.hFy.setLayoutParams(layoutParams9);
                                GI6.hFy.hFk = false;
                                GI6.hFy.setOnClickListener(null);
                                GI6.hFy.bringToFront();
                                break;
                            }
                        }
                    } else {
                        Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
                    break;
                }
                break;
            case 4:
                String str7 = list.get(1);
                Log.i(TAG, "remoteAnd3Camera anchorUserId:" + str + " selfId:" + str2 + " userId1:" + str7);
                if (str7 != null && str7.length() != 0) {
                    b GI7 = GI(str);
                    if (!(GI7 == null || GI7.hFy == null || GI7.hFy.getLayoutParams() == null)) {
                        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) GI7.hFy.getLayoutParams();
                        layoutParams10.width = au.az(getContext()).x / 2;
                        layoutParams10.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                        layoutParams10.setMarginStart(0);
                        layoutParams10.setMarginEnd(0);
                        layoutParams10.topMargin = 0;
                        layoutParams10.bottomMargin = 0;
                        GI7.hFy.setLayoutParams(layoutParams10);
                        GI7.hFy.bringToFront();
                    }
                    if (Util.isEqual(str2, str7)) {
                        b bVar4 = (b) getCameraContentView();
                        if (!(bVar4 == null || bVar4.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) bVar4.getLayoutParams();
                            layoutParams11.width = au.az(getContext()).x / 2;
                            layoutParams11.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams11.topMargin = 0;
                            layoutParams11.bottomMargin = 0;
                            layoutParams11.setMarginStart(layoutParams11.width);
                            layoutParams11.setMarginEnd(0);
                            bVar4.setLayoutParams(layoutParams11);
                            bVar4.hFk = false;
                            bVar4.setOnClickListener(null);
                            bVar4.bringToFront();
                        }
                    } else {
                        b GI8 = GI(str7);
                        if (!(GI8 == null || GI8.hFy == null || GI8.hFy.getLayoutParams() == null)) {
                            RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) GI8.hFy.getLayoutParams();
                            layoutParams12.width = au.az(getContext()).x / 2;
                            layoutParams12.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                            layoutParams12.topMargin = 0;
                            layoutParams12.bottomMargin = 0;
                            layoutParams12.setMarginStart(layoutParams12.width);
                            layoutParams12.setMarginEnd(0);
                            GI8.hFy.setLayoutParams(layoutParams12);
                            GI8.hFy.hFk = false;
                            GI8.hFy.setOnClickListener(null);
                            GI8.hFy.bringToFront();
                        }
                    }
                    String str8 = list.get(2);
                    Log.i(TAG, "remoteAnd3Camera anchorUserId:" + str + " selfId:" + str2 + " userId2:" + str8);
                    if (str8 != null && str8.length() != 0) {
                        if (Util.isEqual(str2, str8)) {
                            b bVar5 = (b) getCameraContentView();
                            if (!(bVar5 == null || bVar5.getLayoutParams() == null)) {
                                RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) bVar5.getLayoutParams();
                                layoutParams13.width = au.az(getContext()).x / 2;
                                layoutParams13.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams13.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams13.bottomMargin = 0;
                                layoutParams13.setMarginStart(0);
                                layoutParams13.setMarginEnd(0);
                                bVar5.setLayoutParams(layoutParams13);
                                bVar5.hFk = false;
                                bVar5.setOnClickListener(null);
                                bVar5.bringToFront();
                            }
                        } else {
                            b GI9 = GI(str8);
                            if (!(GI9 == null || GI9.hFy == null || GI9.hFy.getLayoutParams() == null)) {
                                RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) GI9.hFy.getLayoutParams();
                                layoutParams14.width = au.az(getContext()).x / 2;
                                layoutParams14.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams14.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                layoutParams14.bottomMargin = 0;
                                layoutParams14.setMarginStart(0);
                                layoutParams14.setMarginEnd(0);
                                GI9.hFy.setLayoutParams(layoutParams14);
                                GI9.hFy.hFk = false;
                                GI9.hFy.setOnClickListener(null);
                                GI9.hFy.bringToFront();
                            }
                        }
                        String str9 = list.get(3);
                        Log.i(TAG, "remoteAnd3Camera anchorUserId:" + str + " selfId:" + str2 + " userId3:" + str9);
                        if (str9 != null && str9.length() != 0) {
                            if (Util.isEqual(str2, str9)) {
                                b bVar6 = (b) getCameraContentView();
                                if (!(bVar6 == null || bVar6.getLayoutParams() == null)) {
                                    RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) bVar6.getLayoutParams();
                                    layoutParams15.width = au.az(getContext()).x / 2;
                                    layoutParams15.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                    layoutParams15.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                    layoutParams15.bottomMargin = 0;
                                    layoutParams15.setMarginStart(au.az(getContext()).x / 2);
                                    layoutParams15.setMarginEnd(0);
                                    bVar6.setLayoutParams(layoutParams15);
                                    bVar6.hFk = false;
                                    bVar6.setOnClickListener(null);
                                    bVar6.bringToFront();
                                    break;
                                }
                            } else {
                                b GI10 = GI(str9);
                                if (!(GI10 == null || GI10.hFy == null || GI10.hFy.getLayoutParams() == null)) {
                                    RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) GI10.hFy.getLayoutParams();
                                    layoutParams16.width = au.az(getContext()).x / 2;
                                    layoutParams16.height = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                    layoutParams16.topMargin = ((int) (((float) (au.az(getContext()).x / 2)) * 1.7777778f)) / 2;
                                    layoutParams16.bottomMargin = 0;
                                    layoutParams16.setMarginStart(au.az(getContext()).x / 2);
                                    layoutParams16.setMarginEnd(0);
                                    GI10.hFy.setLayoutParams(layoutParams16);
                                    GI10.hFy.hFk = false;
                                    GI10.hFy.setOnClickListener(null);
                                    GI10.hFy.bringToFront();
                                    break;
                                }
                            }
                        } else {
                            Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                            break;
                        }
                    } else {
                        Log.w(TAG, "halfCameraAndRemote case2 return by userId2 invalid value!");
                        break;
                    }
                } else {
                    Log.w(TAG, "halfCameraAndRemote case2 return by userId1 invalid value!");
                    break;
                }
                break;
        }
        requestLayout();
        AppMethodBeat.o(261586);
    }

    public RelativeLayout getCameraContentView() {
        AppMethodBeat.i(196364);
        for (int i2 = 0; i2 < this.vad.size(); i2++) {
            b bVar = this.vad.get(i2);
            if (bVar.hFy.hEY != null) {
                b bVar2 = bVar.hFy;
                AppMethodBeat.o(196364);
                return bVar2;
            }
        }
        AppMethodBeat.o(196364);
        return null;
    }

    public final int Z(String str, int i2) {
        int i3;
        AppMethodBeat.i(196365);
        int i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 >= this.vad.size()) {
                i3 = -1;
                break;
            }
            b bVar = this.vad.get(i3);
            if (bVar.hFy.mVideoView != null && Util.isEqual(str, bVar.userId) && bVar.streamType == i2) {
                break;
            }
            i4 = i3 + 1;
        }
        AppMethodBeat.o(196365);
        return i3;
    }

    public final void qQ(int i2) {
        AppMethodBeat.i(196366);
        for (int i3 = 1; i3 < this.vad.size(); i3++) {
            b bVar = this.vad.get(i3);
            if (!(bVar.hFy == null || bVar.hFy.hEY == null)) {
                if (i2 == 1) {
                    bVar.hFy.setLayoutParams(c.H(getContext(), getWidth()));
                } else if (i2 == 2) {
                    bVar.hFy.setLayoutParams(c.G(getContext(), getWidth()));
                }
            }
        }
        AppMethodBeat.o(196366);
    }

    public final void c(int i2, String str, int i3) {
        AppMethodBeat.i(196367);
        for (int i4 = 1; i4 < this.vad.size(); i4++) {
            b bVar = this.vad.get(i4);
            if (bVar.hFy != null && Util.isEqual(bVar.userId, str) && bVar.streamType == i3) {
                if (i2 == 1) {
                    bVar.hFy.setLayoutParams(c.H(getContext(), getWidth()));
                } else if (i2 == 2) {
                    bVar.hFy.setLayoutParams(c.G(getContext(), getWidth()));
                }
            }
        }
        AppMethodBeat.o(196367);
    }

    public int getRemoteViewIndex() {
        AppMethodBeat.i(196368);
        for (int i2 = 0; i2 < this.vad.size(); i2++) {
            if (this.vad.get(i2).hFy.mVideoView != null) {
                AppMethodBeat.o(196368);
                return i2;
            }
        }
        AppMethodBeat.o(196368);
        return 0;
    }

    public void setGestureListener(b.a aVar) {
        AppMethodBeat.i(196369);
        for (int i2 = 0; i2 < this.vad.size(); i2++) {
            this.vad.get(i2).hFy.hFn = aVar;
        }
        AppMethodBeat.o(196369);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public b hFy;
        public int index;
        public int streamType;
        public String userId;

        private b() {
            this.index = -1;
            this.userId = "";
            this.streamType = -1;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(TRTCVideoLayoutManager tRTCVideoLayoutManager) {
        AppMethodBeat.i(196370);
        if (tRTCVideoLayoutManager.hFs == null || tRTCVideoLayoutManager.hFs.size() == 0) {
            Context context = tRTCVideoLayoutManager.getContext();
            int width = tRTCVideoLayoutManager.getWidth();
            tRTCVideoLayoutManager.getHeight();
            ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
            arrayList.add(new RelativeLayout.LayoutParams(-1, -1));
            int dip2px = c.dip2px(context, 10.0f);
            int dip2px2 = c.dip2px(context, 15.0f);
            int dip2px3 = c.dip2px(context, 50.0f);
            int dip2px4 = c.dip2px(context, 108.0f);
            int dip2px5 = c.dip2px(context, 192.0f);
            for (int i2 = 0; i2 < 3; i2++) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px4, dip2px5);
                layoutParams.leftMargin = ((width - dip2px2) - dip2px4) - au.aD(context);
                layoutParams.topMargin = dip2px3 + dip2px;
                arrayList.add(layoutParams);
            }
            tRTCVideoLayoutManager.hFs = arrayList;
        }
        for (int i3 = 0; i3 < tRTCVideoLayoutManager.vad.size(); i3++) {
            b bVar = tRTCVideoLayoutManager.vad.get(i3);
            bVar.hFy.setLayoutParams(tRTCVideoLayoutManager.hFs.get(i3));
            if (i3 == 0) {
                bVar.hFy.hFk = false;
            } else {
                bVar.hFy.hFk = true;
            }
            bVar.hFy.setBottomControllerVisibility(8);
            tRTCVideoLayoutManager.addView(bVar.hFy);
        }
        AppMethodBeat.o(196370);
    }
}
