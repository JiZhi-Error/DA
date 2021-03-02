package com.tencent.qqmusic.mediaplayer;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

public class PlayerConfigManager {
    private static final int ADD = 1;
    private static final int DTS_COST_THRESHOLD = 40;
    private static boolean ENABLE_CHANGE_THREAD_PRIORITY = false;
    private static final boolean ENABLE_REAL_CHECK = true;
    private static final int MAX_RATIO = 4;
    private static final int MAX_TIMES = 10;
    private static final int MIN_RATIO = 8;
    private static final int NONE = 0;
    private static final int SUB = -1;
    private static final String TAG = "PlayerConfigManager";
    private static PlayerConfigManager mInstance;
    private int[] THREAD_PRIORITY;
    private int count;
    private int mAddPriority;
    private int mBufRatio;
    private WeakReference<CorePlayer> mCommonPlayerRef;
    private int mCurrPriorityIndex;
    private long mLastDecodeSpeed;
    private long mPlaySpeed;
    private int mProcessorNumber;
    private long mStartTime;

    private PlayerConfigManager() {
        AppMethodBeat.i(76713);
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0;
        this.mPlaySpeed = 1;
        this.mAddPriority = 0;
        this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
        this.mCommonPlayerRef = null;
        this.THREAD_PRIORITY = new int[]{19, 10, -2, -4, -8, -16, -19};
        this.mCurrPriorityIndex = 0;
        this.mBufRatio = 4;
        this.count = 0;
        this.mStartTime = 0;
        AppMethodBeat.o(76713);
    }

    public static synchronized PlayerConfigManager getInstance() {
        PlayerConfigManager playerConfigManager;
        synchronized (PlayerConfigManager.class) {
            AppMethodBeat.i(76714);
            if (mInstance == null) {
                mInstance = new PlayerConfigManager();
            }
            playerConfigManager = mInstance;
            AppMethodBeat.o(76714);
        }
        return playerConfigManager;
    }

    public int getBufRatio() {
        AppMethodBeat.i(76715);
        if (this.mBufRatio <= 1) {
            this.mBufRatio = 4;
        } else if (this.mBufRatio > 8) {
            this.mBufRatio = 8;
        }
        Logger.i(TAG, "getBufRatio = " + this.mBufRatio);
        this.count = 0;
        int i2 = this.mBufRatio;
        AppMethodBeat.o(76715);
        return i2;
    }

    public void calDTSCostStart() {
        AppMethodBeat.i(76716);
        if (this.mBufRatio == 8) {
            AppMethodBeat.o(76716);
            return;
        }
        this.mStartTime = System.currentTimeMillis();
        AppMethodBeat.o(76716);
    }

    public void calDTSCostEnd() {
        AppMethodBeat.i(76717);
        if (this.mBufRatio == 8) {
            AppMethodBeat.o(76717);
            return;
        }
        if (System.currentTimeMillis() - this.mStartTime > 40) {
            this.count++;
            if (this.count > 10) {
                this.mBufRatio *= 2;
                this.count = 0;
            }
        }
        AppMethodBeat.o(76717);
    }

    public boolean isSingleCpuOrScreenOff() {
        AppMethodBeat.i(76718);
        this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
        if (this.mProcessorNumber <= 1) {
            AppMethodBeat.o(76718);
            return true;
        }
        AppMethodBeat.o(76718);
        return false;
    }

    public void setCommonPlayerRef(CorePlayer corePlayer) {
        AppMethodBeat.i(76719);
        if (corePlayer != null) {
            this.mCommonPlayerRef = new WeakReference<>(corePlayer);
            this.mCurrPriorityIndex = 0;
            this.mAddPriority = 0;
            AudioInformation currentAudioInformation = corePlayer.getCurrentAudioInformation();
            if (currentAudioInformation != null) {
                this.mPlaySpeed = (long) (((float) ((currentAudioInformation.getSampleRate() * 2) * ((long) currentAudioInformation.getChannels()))) / 1000.0f);
                Logger.i(TAG, "setCommonPlayerRef info = " + currentAudioInformation + ",mPlaySpeed = " + this.mPlaySpeed);
            }
        }
        AppMethodBeat.o(76719);
    }

    public void changeDecodeThreadPriority() {
        CorePlayer corePlayer;
        AppMethodBeat.i(76720);
        if (!(this.mCommonPlayerRef == null || (corePlayer = this.mCommonPlayerRef.get()) == null)) {
            corePlayer.changePlayThreadPriorityImmediately();
        }
        AppMethodBeat.o(76720);
    }

    private boolean add() {
        return this.mAddPriority > 0;
    }

    private boolean sub() {
        return this.mAddPriority < -1;
    }

    public void changeDecodeThreadPriorityIfNeed() {
        int i2 = 0;
        AppMethodBeat.i(76721);
        try {
            int i3 = this.mCurrPriorityIndex;
            if (isSingleCpuOrScreenOff() && ENABLE_CHANGE_THREAD_PRIORITY) {
                if (add()) {
                    i3++;
                } else if (sub()) {
                    i3--;
                }
                if (i3 != this.mCurrPriorityIndex || i3 < 0 || i3 >= this.THREAD_PRIORITY.length) {
                    if (i3 >= 0) {
                        if (i3 >= this.THREAD_PRIORITY.length) {
                            i2 = this.THREAD_PRIORITY.length - 1;
                        } else {
                            i2 = i3;
                        }
                    }
                    this.mCurrPriorityIndex = i2;
                    this.mAddPriority = 0;
                } else {
                    Logger.i(TAG, "changeDecodeThreadPriorityIfNeed don't change Priority mCurrPriorityIndex = " + this.THREAD_PRIORITY[this.mCurrPriorityIndex]);
                    AppMethodBeat.o(76721);
                    return;
                }
            }
            Process.setThreadPriority(0);
            AppMethodBeat.o(76721);
        } catch (Throwable th) {
            Logger.e(TAG, th);
            AppMethodBeat.o(76721);
        }
    }
}
