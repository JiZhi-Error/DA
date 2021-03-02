package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KJumpRemindInfo;
import com.tencent.kinda.gen.KindaJumpRemindManager;
import com.tencent.kinda.gen.VoidBoolStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.m;

public class KindaJumpRemindManagerImpl implements KindaJumpRemindManager {
    private m jumpRemind = new m();

    public KindaJumpRemindManagerImpl() {
        AppMethodBeat.i(18450);
        AppMethodBeat.o(18450);
    }

    @Override // com.tencent.kinda.gen.KindaJumpRemindManager
    public void jumpRemindImpl(KJumpRemindInfo kJumpRemindInfo, int i2, int i3, final VoidBoolStringCallback voidBoolStringCallback, final VoidBoolStringCallback voidBoolStringCallback2) {
        AppMethodBeat.i(18451);
        cfm cfm = new cfm();
        cfm.uSc = kJumpRemindInfo.mJumpType;
        cfm.Mlw = kJumpRemindInfo.mIsPopUpWindows;
        cfm.dQx = kJumpRemindInfo.mWording;
        cfm.lHA = kJumpRemindInfo.mLeftButtonWording;
        cfm.lHB = kJumpRemindInfo.mRightButtonWording;
        dlx dlx = new dlx();
        dlx.type = kJumpRemindInfo.mUrl.mType;
        dlx.dNI = kJumpRemindInfo.mUrl.mAppid;
        dlx.MPC = kJumpRemindInfo.mUrl.mAppVersion;
        dlx.path = kJumpRemindInfo.mUrl.mPath;
        dlx.gTt = kJumpRemindInfo.mUrl.mBtnName;
        cfm.Mlx = dlx;
        cfm.title = kJumpRemindInfo.mTitle;
        this.jumpRemind = m.a(cfm);
        this.jumpRemind.RtM = true;
        this.jumpRemind.hhn();
        this.jumpRemind.a((Activity) KindaContext.get(), new f() {
            /* class com.tencent.kinda.framework.app.KindaJumpRemindManagerImpl.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.c.f
            public void onCancel() {
                AppMethodBeat.i(18447);
                if (KindaJumpRemindManagerImpl.this.jumpRemind.hhm()) {
                    if (voidBoolStringCallback2 != null) {
                        voidBoolStringCallback2.call(false, null);
                    }
                } else if (voidBoolStringCallback != null) {
                    voidBoolStringCallback.call(false, null);
                }
                KindaJumpRemindManagerImpl.this.jumpRemind.hho();
                AppMethodBeat.o(18447);
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public void onEnter() {
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public void onUrlOk() {
                AppMethodBeat.i(18448);
                if (KindaJumpRemindManagerImpl.this.jumpRemind.hhm()) {
                    if (voidBoolStringCallback2 != null) {
                        voidBoolStringCallback2.call(true, null);
                    }
                } else if (voidBoolStringCallback != null) {
                    voidBoolStringCallback.call(true, null);
                }
                KindaJumpRemindManagerImpl.this.jumpRemind.hho();
                AppMethodBeat.o(18448);
            }

            @Override // com.tencent.mm.wallet_core.c.f
            public void onUrlCancel() {
                AppMethodBeat.i(18449);
                if (KindaJumpRemindManagerImpl.this.jumpRemind.hhm()) {
                    if (voidBoolStringCallback2 != null) {
                        voidBoolStringCallback2.call(false, null);
                    }
                } else if (voidBoolStringCallback != null) {
                    voidBoolStringCallback.call(false, null);
                }
                KindaJumpRemindManagerImpl.this.jumpRemind.hho();
                AppMethodBeat.o(18449);
            }
        });
        AppMethodBeat.o(18451);
    }

    @Override // com.tencent.kinda.gen.KindaJumpRemindManager
    public void onDestroyJumpRemindManager() {
        AppMethodBeat.i(18452);
        if (this.jumpRemind != null) {
            this.jumpRemind.hho();
        }
        AppMethodBeat.o(18452);
    }
}
