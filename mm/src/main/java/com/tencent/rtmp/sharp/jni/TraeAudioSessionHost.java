package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList<SessionInfo> _sessionInfoList = new ArrayList<>();
    private ReentrantLock mLock = new ReentrantLock();

    public TraeAudioSessionHost() {
        AppMethodBeat.i(13785);
        AppMethodBeat.o(13785);
    }

    public class SessionInfo {
        public TraeAudioSession _traeAs;
        public long sessionId;

        public SessionInfo() {
        }
    }

    public SessionInfo find(long j2) {
        SessionInfo sessionInfo;
        AppMethodBeat.i(13786);
        this.mLock.lock();
        int i2 = 0;
        while (true) {
            if (i2 >= this._sessionInfoList.size()) {
                sessionInfo = null;
                break;
            }
            sessionInfo = this._sessionInfoList.get(i2);
            if (sessionInfo.sessionId == j2) {
                break;
            }
            i2++;
        }
        this.mLock.unlock();
        AppMethodBeat.o(13786);
        return sessionInfo;
    }

    public void add(TraeAudioSession traeAudioSession, long j2, Context context) {
        AppMethodBeat.i(13787);
        if (find(j2) != null) {
            AppMethodBeat.o(13787);
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.sessionId = j2;
        sessionInfo._traeAs = traeAudioSession;
        this.mLock.lock();
        this._sessionInfoList.add(sessionInfo);
        this.mLock.unlock();
        AppMethodBeat.o(13787);
    }

    public void remove(long j2) {
        AppMethodBeat.i(13788);
        this.mLock.lock();
        int i2 = 0;
        while (true) {
            if (i2 >= this._sessionInfoList.size()) {
                break;
            } else if (this._sessionInfoList.get(i2).sessionId == j2) {
                this._sessionInfoList.remove(i2);
                break;
            } else {
                i2++;
            }
        }
        this.mLock.unlock();
        AppMethodBeat.o(13788);
    }

    public void sendToAudioSessionMessage(Intent intent) {
        AppMethodBeat.i(13789);
        this.mLock.lock();
        for (int i2 = 0; i2 < this._sessionInfoList.size(); i2++) {
            this._sessionInfoList.get(i2)._traeAs.onReceiveCallback(intent);
        }
        this.mLock.unlock();
        AppMethodBeat.o(13789);
    }
}
