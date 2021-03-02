package com.tencent.tav.player;

import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioFocusHelper {
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private AudioManager mAudioManager;
    private Context mContext;
    private boolean mIsAudioFocus;
    private Player mPlayer;

    static /* synthetic */ void access$200(AudioFocusHelper audioFocusHelper, boolean z) {
        AppMethodBeat.i(218534);
        audioFocusHelper.onAudioFocusLoss(z);
        AppMethodBeat.o(218534);
    }

    public AudioFocusHelper(Context context, Player player) {
        this.mContext = context;
        this.mPlayer = player;
    }

    public void requestFocus() {
        boolean z = true;
        AppMethodBeat.i(218529);
        ensureAudioManager();
        if (!this.mIsAudioFocus) {
            if (this.mAudioManager.requestAudioFocus(getAudioFocusChangeListener(), 3, 1) != 1) {
                z = false;
            }
            this.mIsAudioFocus = z;
        }
        AppMethodBeat.o(218529);
    }

    public void release() {
        AppMethodBeat.i(218530);
        if (this.mAudioManager != null) {
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mAudioManager = null;
            this.mAudioFocusListener = null;
            this.mIsAudioFocus = false;
        }
        if (this.mPlayer != null) {
            this.mPlayer = null;
        }
        AppMethodBeat.o(218530);
    }

    private void ensureAudioManager() {
        AppMethodBeat.i(218531);
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        AppMethodBeat.o(218531);
    }

    private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener() {
        AppMethodBeat.i(218532);
        if (this.mAudioFocusListener == null) {
            this.mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
                /* class com.tencent.tav.player.AudioFocusHelper.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public void onAudioFocusChange(int i2) {
                    AppMethodBeat.i(218528);
                    if (AudioFocusHelper.this.mPlayer == null) {
                        AppMethodBeat.o(218528);
                        return;
                    }
                    switch (i2) {
                        case -2:
                            AudioFocusHelper.access$200(AudioFocusHelper.this, true);
                            break;
                        case -1:
                            AudioFocusHelper.access$200(AudioFocusHelper.this, false);
                            AppMethodBeat.o(218528);
                            return;
                        case 1:
                            try {
                                AudioFocusHelper.this.mIsAudioFocus = true;
                                AppMethodBeat.o(218528);
                                return;
                            } catch (Exception e2) {
                                AppMethodBeat.o(218528);
                                return;
                            }
                    }
                    AppMethodBeat.o(218528);
                }
            };
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.mAudioFocusListener;
        AppMethodBeat.o(218532);
        return onAudioFocusChangeListener;
    }

    private void onAudioFocusLoss(boolean z) {
        AppMethodBeat.i(218533);
        if (!z) {
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mIsAudioFocus = false;
        }
        if (this.mPlayer != null && this.mPlayer.isPlaying()) {
            this.mPlayer.pause();
        }
        AppMethodBeat.o(218533);
    }
}
