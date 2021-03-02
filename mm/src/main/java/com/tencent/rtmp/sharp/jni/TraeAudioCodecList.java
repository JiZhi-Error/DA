package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioCodecList {
    private ArrayList<CodecInfo> _sessionInfoList = new ArrayList<>();
    private ReentrantLock mLock = new ReentrantLock();

    public TraeAudioCodecList() {
        AppMethodBeat.i(13780);
        AppMethodBeat.o(13780);
    }

    public class CodecInfo {
        public byte[] _tempBufdec;
        public AudioDecoder audioDecoder;
        public long sessionId;

        public CodecInfo() {
        }
    }

    public CodecInfo find(long j2) {
        CodecInfo codecInfo;
        AppMethodBeat.i(13781);
        this.mLock.lock();
        int i2 = 0;
        while (true) {
            if (i2 >= this._sessionInfoList.size()) {
                codecInfo = null;
                break;
            }
            codecInfo = this._sessionInfoList.get(i2);
            if (codecInfo.sessionId == j2) {
                break;
            }
            i2++;
        }
        this.mLock.unlock();
        AppMethodBeat.o(13781);
        return codecInfo;
    }

    public CodecInfo add(long j2) {
        AppMethodBeat.i(13782);
        CodecInfo find = find(j2);
        if (find != null) {
            AppMethodBeat.o(13782);
            return find;
        }
        CodecInfo codecInfo = new CodecInfo();
        codecInfo.sessionId = j2;
        codecInfo.audioDecoder = new AudioDecoder();
        codecInfo._tempBufdec = new byte[3840];
        this.mLock.lock();
        this._sessionInfoList.add(codecInfo);
        this.mLock.unlock();
        CodecInfo find2 = find(j2);
        AppMethodBeat.o(13782);
        return find2;
    }

    public void remove(long j2) {
        AppMethodBeat.i(13783);
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
        AppMethodBeat.o(13783);
    }
}
