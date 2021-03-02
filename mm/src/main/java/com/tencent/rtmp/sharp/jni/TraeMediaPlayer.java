package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
    public static final int TRAE_MEDIAPLAER_STOP = 100;
    private Context _context;
    private int _durationMS = -1;
    private boolean _hasCall = false;
    private boolean _loop = false;
    int _loopCount = 0;
    private int _prevVolume = -1;
    boolean _ringMode = false;
    private int _streamType = 0;
    private Timer _watchTimer = null;
    private TimerTask _watchTimertask = null;
    private OnCompletionListener mCallback;
    private MediaPlayer mMediaPlay = null;

    public interface OnCompletionListener {
        void onCompletion();
    }

    public TraeMediaPlayer(Context context, OnCompletionListener onCompletionListener) {
        this._context = context;
        this.mCallback = onCompletionListener;
    }

    public boolean playRing(int i2, int i3, Uri uri, String str, boolean z, int i4, boolean z2, boolean z3, int i5) {
        AppMethodBeat.i(13638);
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "TraeMediaPlay | playRing datasource:" + i2 + " rsid:" + i3 + " uri:" + uri + " filepath:" + str + " loop:" + (z ? "Y" : "N") + " :loopCount" + i4 + " ringMode:" + (z2 ? "Y" : "N") + " hasCall:" + z3 + " cst:" + i5);
        }
        if (z || i4 > 0) {
            try {
                if (this.mMediaPlay != null) {
                    if (this.mMediaPlay.isPlaying()) {
                        AppMethodBeat.o(13638);
                        return false;
                    }
                    try {
                        this.mMediaPlay.release();
                        this.mMediaPlay = null;
                    } catch (Exception e2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "release MediaPlayer failed." + e2.getMessage());
                        }
                        this.mMediaPlay = null;
                    } catch (Throwable th) {
                        this.mMediaPlay = null;
                        AppMethodBeat.o(13638);
                        throw th;
                    }
                }
                if (this._watchTimer != null) {
                    this._watchTimer.cancel();
                    this._watchTimer = null;
                    this._watchTimertask = null;
                }
                AudioManager audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                this.mMediaPlay = new MediaPlayer();
                if (this.mMediaPlay == null) {
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    AppMethodBeat.o(13638);
                    return false;
                }
                this.mMediaPlay.setOnCompletionListener(this);
                this.mMediaPlay.setOnErrorListener(this);
                switch (i2) {
                    case 0:
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "TraeMediaPlay | rsid:".concat(String.valueOf(i3)));
                        }
                        AssetFileDescriptor openRawResourceFd = this._context.getResources().openRawResourceFd(i3);
                        if (openRawResourceFd != null) {
                            this.mMediaPlay.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                            openRawResourceFd.close();
                            break;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "TraeMediaPlay | afd == null rsid:".concat(String.valueOf(i3)));
                            }
                            this.mMediaPlay.release();
                            this.mMediaPlay = null;
                            AppMethodBeat.o(13638);
                            return false;
                        }
                    case 1:
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "TraeMediaPlay | uri:".concat(String.valueOf(uri)));
                        }
                        this.mMediaPlay.setDataSource(this._context, uri);
                        break;
                    case 2:
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "TraeMediaPlay | FilePath:".concat(String.valueOf(str)));
                        }
                        this.mMediaPlay.setDataSource(str);
                        break;
                    default:
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "TraeMediaPlay | err datasource:".concat(String.valueOf(i2)));
                        }
                        this.mMediaPlay.release();
                        this.mMediaPlay = null;
                        break;
                }
                if (this.mMediaPlay == null) {
                    AppMethodBeat.o(13638);
                    return false;
                }
                this._ringMode = z2;
                int i6 = 0;
                if (this._ringMode) {
                    this._streamType = 2;
                    i6 = 1;
                } else {
                    this._streamType = 0;
                    if (Build.VERSION.SDK_INT >= 11) {
                        i6 = 3;
                    }
                }
                this._hasCall = z3;
                if (this._hasCall) {
                    this._streamType = i5;
                }
                this.mMediaPlay.setAudioStreamType(this._streamType);
                this.mMediaPlay.prepare();
                this.mMediaPlay.setLooping(z);
                this.mMediaPlay.start();
                this._loop = z;
                if (this._loop) {
                    this._loopCount = 1;
                    this._durationMS = -1;
                } else {
                    this._loopCount = i4;
                    this._durationMS = this._loopCount * this.mMediaPlay.getDuration();
                }
                this._loopCount--;
                if (!this._hasCall) {
                    audioManager.setMode(i6);
                }
                if (this._durationMS > 0) {
                    this._watchTimer = new Timer();
                    this._watchTimertask = new TimerTask() {
                        /* class com.tencent.rtmp.sharp.jni.TraeMediaPlayer.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(13893);
                            if (TraeMediaPlayer.this.mMediaPlay != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("TRAE", 2, "TraeMediaPlay | play timeout");
                                }
                                if (TraeMediaPlayer.this.mCallback != null) {
                                    TraeMediaPlayer.this.mCallback.onCompletion();
                                }
                            }
                            AppMethodBeat.o(13893);
                        }
                    };
                    this._watchTimer.schedule(this._watchTimertask, (long) (this._durationMS + 1000));
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "TraeMediaPlay | DurationMS:" + this.mMediaPlay.getDuration() + " loop:" + z);
                }
                AppMethodBeat.o(13638);
                return true;
            } catch (IllegalStateException e3) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("TRAE", 2, "TraeMediaPlay | IllegalStateException: " + e3.getLocalizedMessage() + " " + e3.getMessage());
                    }
                } catch (Exception e4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TRAE", 2, "TraeMediaPlay | Except: " + e4.getLocalizedMessage() + " " + e4.getMessage());
                    }
                }
                try {
                    this.mMediaPlay.release();
                } catch (Exception e5) {
                }
                this.mMediaPlay = null;
                AppMethodBeat.o(13638);
                return false;
            } catch (IOException e6) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "TraeMediaPlay | IOException: " + e6.getLocalizedMessage() + " " + e6.getMessage());
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.o(13638);
                return false;
            } catch (IllegalArgumentException e7) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "TraeMediaPlay | IllegalArgumentException: " + e7.getLocalizedMessage() + " " + e7.getMessage());
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.o(13638);
                return false;
            } catch (SecurityException e8) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "TraeMediaPlay | SecurityException: " + e8.getLocalizedMessage() + " " + e8.getMessage());
                }
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                AppMethodBeat.o(13638);
                return false;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeMediaPlay | playRing err datasource:" + i2 + " loop:" + (z ? "Y" : "N") + " :loopCount" + i4);
            }
            AppMethodBeat.o(13638);
            return false;
        }
    }

    public void stopRing() {
        AppMethodBeat.i(13639);
        if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
        }
        if (this.mMediaPlay == null) {
            AppMethodBeat.o(13639);
            return;
        }
        if (this.mMediaPlay.isPlaying()) {
            this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        try {
            if (this._watchTimer != null) {
                this._watchTimer.cancel();
                this._watchTimer = null;
                this._watchTimertask = null;
            }
            this.mMediaPlay.release();
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "release MediaPlayer failed." + e2.getMessage());
            }
        }
        this.mMediaPlay = null;
        this._durationMS = -1;
        AppMethodBeat.o(13639);
    }

    public int getStreamType() {
        return this._streamType;
    }

    public int getDuration() {
        return this._durationMS;
    }

    public boolean hasCall() {
        return this._hasCall;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        AppMethodBeat.i(13640);
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
        if (this._loop) {
            if (QLog.isColorLevel()) {
                QLog.d("TRAE", 2, "loop play,continue...");
            }
            AppMethodBeat.o(13640);
            return;
        }
        try {
            if (this._loopCount <= 0) {
                volumeUndo();
                if (this.mMediaPlay.isPlaying()) {
                    this.mMediaPlay.stop();
                }
                this.mMediaPlay.reset();
                this.mMediaPlay.release();
                this.mMediaPlay = null;
                if (this.mCallback != null) {
                    this.mCallback.onCompletion();
                }
            } else {
                this.mMediaPlay.start();
                this._loopCount--;
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "stop play failed." + e2.getMessage());
            }
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13640);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        AppMethodBeat.i(13641);
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + i2 + " arg2:" + i3);
        try {
            this.mMediaPlay.release();
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "release MediaPlayer failed." + e2.getMessage());
            }
        }
        this.mMediaPlay = null;
        if (this.mCallback != null) {
            this.mCallback.onCompletion();
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(13641);
        return false;
    }

    private void volumeDo() {
        AppMethodBeat.i(13642);
        if (this.mMediaPlay == null || !this._ringMode || this._streamType == 2) {
            AppMethodBeat.o(13642);
            return;
        }
        try {
            AudioManager audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            int streamVolume = audioManager.getStreamVolume(this._streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(this._streamType);
            int streamVolume2 = audioManager.getStreamVolume(2);
            int streamMaxVolume2 = audioManager.getStreamMaxVolume(2);
            int i2 = (int) (((((double) streamVolume2) * 1.0d) / ((double) streamMaxVolume2)) * ((double) streamMaxVolume));
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + streamVolume + " maxV:" + streamMaxVolume + " currRV:" + streamVolume2 + " maxRV:" + streamMaxVolume2 + " setV:" + i2);
            }
            if (i2 + 1 < streamMaxVolume) {
                streamMaxVolume = i2 + 1;
            }
            audioManager.setStreamVolume(this._streamType, streamMaxVolume, 0);
            this._prevVolume = streamVolume;
            AppMethodBeat.o(13642);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "set stream volume failed." + e2.getMessage());
            }
            AppMethodBeat.o(13642);
        }
    }

    private void volumeUndo() {
        AppMethodBeat.i(13643);
        if (this.mMediaPlay == null || !this._ringMode || this._streamType == 2 || this._prevVolume == -1) {
            AppMethodBeat.o(13643);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
            }
            ((AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setStreamVolume(this._streamType, this._prevVolume, 0);
            AppMethodBeat.o(13643);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "set stream volume failed." + e2.getMessage());
            }
            AppMethodBeat.o(13643);
        }
    }
}
