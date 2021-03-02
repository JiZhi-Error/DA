package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class l {

    public enum a {
        NOTSET,
        ON,
        OFF;

        public static a valueOf(String str) {
            AppMethodBeat.i(65969);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(65969);
            return aVar;
        }

        static {
            AppMethodBeat.i(65970);
            AppMethodBeat.o(65970);
        }
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(65971);
        if (context == null || aVar == null) {
            Log.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", context, Integer.valueOf((int) R.string.ent), aVar, Boolean.FALSE);
            AppMethodBeat.o(65971);
        } else if (!b.apN()) {
            AppMethodBeat.o(65971);
        } else if (!b.apR()) {
            AppMethodBeat.o(65971);
        } else {
            final String string = context.getString(R.string.ent);
            k kVar = new k();
            if (aVar != a.NOTSET) {
                kVar.setAudioStreamType(aVar == a.ON ? 5 : 0);
            }
            Log.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", Integer.valueOf(kVar.hashCode()), string, context, Integer.valueOf((int) R.string.ent), aVar, Boolean.FALSE);
            try {
                AssetFileDescriptor openFd = context.getAssets().openFd(string);
                kVar.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                openFd.close();
                kVar.setLooping(false);
                kVar.prepare();
                kVar.start();
                kVar.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.l.AnonymousClass1 */

                    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                        AppMethodBeat.i(65966);
                        Log.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        AppMethodBeat.o(65966);
                        return false;
                    }
                });
                kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.l.AnonymousClass2 */

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(65967);
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = string;
                        Log.i("MicroMsg.LuckySoundUtil", "play completion mp:%d  path:%s", objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        AppMethodBeat.o(65967);
                    }
                });
                AppMethodBeat.o(65971);
            } catch (Exception e2) {
                Log.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", Integer.valueOf((int) R.string.ent), e2.getMessage());
                Log.printErrStackTrace("MicroMsg.LuckySoundUtil", e2, "", new Object[0]);
                AppMethodBeat.o(65971);
            }
        }
    }
}
