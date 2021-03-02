package com.tencent.liteav.audio;

import android.text.TextUtils;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TXCSoundEffectPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
    private static final String TAG = "AudioCenter:TXCSoundEffectPlayer";
    private static WeakReference<b> mWeakSoundEffectListener;
    private List<Integer> mShortEffectorIDList = new ArrayList();

    static {
        AppMethodBeat.i(16342);
        f.f();
        AppMethodBeat.o(16342);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final TXCSoundEffectPlayer f156a = new TXCSoundEffectPlayer();

        static {
            AppMethodBeat.i(16298);
            AppMethodBeat.o(16298);
        }
    }

    public static TXCSoundEffectPlayer getInstance() {
        AppMethodBeat.i(16331);
        TXCSoundEffectPlayer tXCSoundEffectPlayer = a.f156a;
        AppMethodBeat.o(16331);
        return tXCSoundEffectPlayer;
    }

    public TXCSoundEffectPlayer() {
        AppMethodBeat.i(221854);
        AppMethodBeat.o(221854);
    }

    public boolean playEffectWithId(int i2, String str, boolean z, int i3) {
        AppMethodBeat.i(16333);
        TXCLog.i(TAG, "playEffectWithId -> effect id = " + i2 + ", path = " + str + ", loop = " + i3);
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i2, checkIfAssetsFile(str));
        audioMusicParam.publish = z;
        audioMusicParam.loopCount = i3;
        audioMusicParam.isShortFile = true;
        boolean startPlayMusic = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(audioMusicParam);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(i2, this);
        this.mShortEffectorIDList.add(Integer.valueOf(i2));
        TXCLog.i(TAG, "playEffectWithId ->effect id = " + i2 + ", startPlayMusic result = " + startPlayMusic);
        AppMethodBeat.o(16333);
        return startPlayMusic;
    }

    public void stopEffectWithId(int i2) {
        AppMethodBeat.i(16334);
        TXCLog.i(TAG, "stopEffectWithId -> effect id = ".concat(String.valueOf(i2)));
        TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(i2, null);
        TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(i2);
        int indexOf = this.mShortEffectorIDList.indexOf(Integer.valueOf(i2));
        if (indexOf >= 0) {
            this.mShortEffectorIDList.remove(indexOf);
        }
        AppMethodBeat.o(16334);
    }

    public void stopAllEffect() {
        AppMethodBeat.i(16335);
        TXCLog.i(TAG, "stopAllEffect -> start");
        for (Integer num : this.mShortEffectorIDList) {
            TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(num.intValue());
        }
        this.mShortEffectorIDList.clear();
        TXCLog.i(TAG, "stopAllEffect -> finish");
        AppMethodBeat.o(16335);
    }

    public void setEffectsVolume(float f2) {
        AppMethodBeat.i(221855);
        TXCLog.i(TAG, "setEffectsVolume -> volume = ".concat(String.valueOf(f2)));
        for (Integer num : this.mShortEffectorIDList) {
            TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(num.intValue(), (int) (100.0f * f2));
        }
        AppMethodBeat.o(221855);
    }

    public void setVolumeOfEffect(int i2, float f2) {
        AppMethodBeat.i(221856);
        TXCLog.i(TAG, "setVolumeOfEffect -> effect id = " + i2 + ", volume = " + f2);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(i2, (int) (100.0f * f2));
        AppMethodBeat.o(221856);
    }

    public void pauseEffectWithId(int i2) {
        AppMethodBeat.i(182286);
        TXCLog.i(TAG, "pauseEffectWithId -> effect id = ".concat(String.valueOf(i2)));
        TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(i2);
        AppMethodBeat.o(182286);
    }

    public void resumeEffectWithId(int i2) {
        AppMethodBeat.i(182287);
        TXCLog.i(TAG, "resumeEffectWithId -> effect id = ".concat(String.valueOf(i2)));
        TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(i2);
        AppMethodBeat.o(182287);
    }

    public void setSoundEffectListener(b bVar) {
        AppMethodBeat.i(16339);
        if (bVar == null) {
            mWeakSoundEffectListener = null;
            AppMethodBeat.o(16339);
            return;
        }
        mWeakSoundEffectListener = new WeakReference<>(bVar);
        AppMethodBeat.o(16339);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i2, long j2, long j3) {
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i2, int i3) {
        AppMethodBeat.i(221857);
        TXCLog.i(TAG, "onStart -> effect id = " + i2 + ", errCode = " + i3);
        if (!(mWeakSoundEffectListener == null || mWeakSoundEffectListener.get() == null)) {
            mWeakSoundEffectListener.get().onEffectPlayStart(i2, i3);
        }
        AppMethodBeat.o(221857);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i2, int i3) {
        AppMethodBeat.i(221858);
        TXCLog.i(TAG, "onMusicPlayFinish -> effect id = ".concat(String.valueOf(i2)));
        if (!(mWeakSoundEffectListener == null || mWeakSoundEffectListener.get() == null)) {
            mWeakSoundEffectListener.get().onEffectPlayFinish(i2);
        }
        AppMethodBeat.o(221858);
    }

    public void clearCache() {
        AppMethodBeat.i(221859);
        if (TXCCommonUtil.getAppContext() == null) {
            AppMethodBeat.o(221859);
            return;
        }
        try {
            File file = new File(getEffectCachePath());
            if (file.exists() && file.isDirectory() && c.a(file) > 52428800) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
            AppMethodBeat.o(221859);
        } catch (Exception e2) {
            TXCLog.w(TAG, "clearCache error " + e2.toString());
            AppMethodBeat.o(221859);
        }
    }

    private String getEffectCachePath() {
        AppMethodBeat.i(221860);
        if (TXCCommonUtil.getAppContext() == null) {
            AppMethodBeat.o(221860);
            return "";
        }
        String str = TXCCommonUtil.getAppContext().getCacheDir() + File.separator + "liteav_effect";
        AppMethodBeat.o(221860);
        return str;
    }

    private String checkIfAssetsFile(String str) {
        long j2;
        Exception e2;
        String str2;
        AppMethodBeat.i(221861);
        if (TextUtils.isEmpty(str) || TXCCommonUtil.getAppContext() == null) {
            AppMethodBeat.o(221861);
            return str;
        } else if (!str.startsWith("/assets/")) {
            AppMethodBeat.o(221861);
            return str;
        } else {
            String substring = str.substring(8);
            try {
                j2 = TXCCommonUtil.getAppContext().getAssets().openFd(substring).getLength();
            } catch (Exception e3) {
                TXCLog.e(TAG, "playAudioEffect openFd error " + e3.toString());
                j2 = 0;
            }
            try {
                String effectCachePath = getEffectCachePath();
                File file = new File(effectCachePath);
                if (!file.exists()) {
                    file.mkdirs();
                } else if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
                int lastIndexOf = substring.lastIndexOf(File.separatorChar);
                if (lastIndexOf != -1) {
                    str2 = effectCachePath + File.separator + j2 + "_" + substring.substring(lastIndexOf + 1);
                } else {
                    str2 = effectCachePath + File.separator + j2 + "_" + substring;
                }
                try {
                    if (!c.a(str2)) {
                        c.a(TXCCommonUtil.getAppContext(), substring, str2);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    TXCLog.e(TAG, "playAudioEffect error " + e2.toString());
                    AppMethodBeat.o(221861);
                    return str2;
                }
            } catch (Exception e5) {
                e2 = e5;
                str2 = str;
                TXCLog.e(TAG, "playAudioEffect error " + e2.toString());
                AppMethodBeat.o(221861);
                return str2;
            }
            AppMethodBeat.o(221861);
            return str2;
        }
    }
}
