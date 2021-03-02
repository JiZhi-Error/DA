package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* access modifiers changed from: package-private */
public class PlayerStateRunner {
    private static final String TAG = "StateRunner";
    private WeakReference<AudioTrack> mAudioTrack = new WeakReference<>(null);
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private Integer mState;

    PlayerStateRunner(Integer num) {
        AppMethodBeat.i(76670);
        this.mState = num;
        AppMethodBeat.o(76670);
    }

    /* access modifiers changed from: package-private */
    public Integer transfer(Integer num) {
        AppMethodBeat.i(76671);
        this.mLock.writeLock().lock();
        try {
            Integer num2 = this.mState;
            this.mState = num;
            Logger.i(TAG, num2.toString() + " -> " + this.mState.toString());
            return num2;
        } finally {
            this.mLock.writeLock().unlock();
            AppMethodBeat.o(76671);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean transfer(Integer num, Integer... numArr) {
        AppMethodBeat.i(76672);
        this.mLock.writeLock().lock();
        try {
            if (isEqual(numArr)) {
                transfer(num);
                this.mLock.writeLock().unlock();
                AppMethodBeat.o(76672);
                return true;
            }
            this.mLock.writeLock().unlock();
            AppMethodBeat.o(76672);
            return false;
        } catch (Throwable th) {
            this.mLock.writeLock().unlock();
            AppMethodBeat.o(76672);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEqual(Integer... numArr) {
        AppMethodBeat.i(76673);
        this.mLock.readLock().lock();
        try {
            for (Integer num : numArr) {
                if (this.mState.equals(num)) {
                    this.mLock.readLock().unlock();
                    AppMethodBeat.o(76673);
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.readLock().unlock();
            AppMethodBeat.o(76673);
        }
    }

    /* access modifiers changed from: package-private */
    public Integer get() {
        int i2;
        AppMethodBeat.i(76674);
        this.mLock.readLock().lock();
        try {
            int intValue = this.mState.intValue();
            AudioTrack audioTrack = this.mAudioTrack.get();
            if (audioTrack != null) {
                switch (audioTrack.getPlayState()) {
                    case 2:
                        i2 = 5;
                        break;
                    case 3:
                        i2 = 4;
                        break;
                    default:
                        i2 = intValue;
                        break;
                }
                if (!this.mState.equals(Integer.valueOf(i2))) {
                    Logger.e(TAG, "!mState.equals(state), mstate = " + this.mState.toString() + "   state = " + i2);
                }
            } else {
                i2 = intValue;
            }
            return Integer.valueOf(i2);
        } finally {
            this.mLock.readLock().unlock();
            AppMethodBeat.o(76674);
        }
    }

    public void setAudioTrack(AudioTrack audioTrack) {
        AppMethodBeat.i(76675);
        this.mAudioTrack = new WeakReference<>(audioTrack);
        AppMethodBeat.o(76675);
    }
}
