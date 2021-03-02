package com.tencent.mm.game.liblockstep;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

@Keep
public class LockStepNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_LOCKSTEP_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static String TAG = "LockStepNative";
    private boolean initCallBackFlag = false;
    volatile long mNativeInst = 0;

    @Keep
    public interface ILockStepListener {
        @Keep
        void onCallBack(long j2, String str);
    }

    @Keep
    public interface ILockStepReportListener {
        @Keep
        int getNetworkType();

        @Keep
        void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3);

        @Keep
        void onKvStat(int i2, String str);
    }

    private native void destoryBindingLockStep(long j2);

    private native long initBindingLockStep(long j2, long j3, long j4);

    private native int initCallBack(long j2, ILockStepListener iLockStepListener, ILockStepReportListener iLockStepReportListener);

    private static native void initConfigLockStep(long j2, HashMap<String, String> hashMap);

    public static native void test();

    private native void testLockStepBinding(long j2);

    private native void updateNativeUdpInterface(long j2, long j3);

    @Keep
    public LockStepNative(long j2, long j3, long j4) {
        AppMethodBeat.i(224178);
        this.mNativeInst = initBindingLockStep(j2, j3, j4);
        AppMethodBeat.o(224178);
    }

    @Keep
    public void destoryLockStep() {
        AppMethodBeat.i(43432);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(43432);
            return;
        }
        if (this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingLockStep(this.mNativeInst);
            this.mNativeInst = -1;
        }
        AppMethodBeat.o(43432);
    }

    @Keep
    public int setCallback(final ILockStepListener iLockStepListener, final ILockStepReportListener iLockStepReportListener) {
        AppMethodBeat.i(43433);
        if (this.mNativeInst == -1) {
            int i2 = NEW_LOCKSTEP_ERROR;
            AppMethodBeat.o(43433);
            return i2;
        } else if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, new ILockStepListener() {
                /* class com.tencent.mm.game.liblockstep.LockStepNative.AnonymousClass1 */

                @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener
                public final void onCallBack(long j2, String str) {
                    AppMethodBeat.i(43427);
                    iLockStepListener.onCallBack(j2, str);
                    AppMethodBeat.o(43427);
                }
            }, new ILockStepReportListener() {
                /* class com.tencent.mm.game.liblockstep.LockStepNative.AnonymousClass2 */

                @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                public final int getNetworkType() {
                    AppMethodBeat.i(43428);
                    int networkType = iLockStepReportListener.getNetworkType();
                    AppMethodBeat.o(43428);
                    return networkType;
                }

                @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                public final void onKvStat(int i2, String str) {
                    AppMethodBeat.i(43429);
                    iLockStepReportListener.onKvStat(i2, str);
                    AppMethodBeat.o(43429);
                }

                @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                public final void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
                    AppMethodBeat.i(43430);
                    iLockStepReportListener.onIdKeyStat(iArr, iArr2, iArr3);
                    AppMethodBeat.o(43430);
                }
            });
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                AppMethodBeat.o(43433);
                return initCallBack;
            }
            int i3 = INIT_ERROR;
            AppMethodBeat.o(43433);
            return i3;
        } else {
            int i4 = REPEAT_INIT_ERROR;
            AppMethodBeat.o(43433);
            return i4;
        }
    }

    @Keep
    public void initConfig(HashMap<String, String> hashMap) {
        AppMethodBeat.i(43434);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(43434);
            return;
        }
        initConfigLockStep(this.mNativeInst, hashMap);
        AppMethodBeat.o(43434);
    }

    @Keep
    public void updateNativeInterface(long j2) {
        AppMethodBeat.i(43435);
        new StringBuilder("mmudp updateNativeInterface mNativeInst:").append(this.mNativeInst).append(",locksteplogicId:").append(j2);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(43435);
            return;
        }
        updateNativeUdpInterface(this.mNativeInst, j2);
        AppMethodBeat.o(43435);
    }

    public void testLockStepBinding() {
        AppMethodBeat.i(43436);
        if (this.mNativeInst == -1) {
            AppMethodBeat.o(43436);
            return;
        }
        testLockStepBinding(this.mNativeInst);
        AppMethodBeat.o(43436);
    }
}
