package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.music.f.a.a;
import com.tencent.mm.plugin.music.f.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public final class b implements c {
    @Override // com.tencent.mm.plugin.music.f.a.c
    public final boolean load(String str) {
        AppMethodBeat.i(63134);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary lib_name is null");
            AppMethodBeat.o(63134);
            return false;
        } else if (j.Ee(str)) {
            AppMethodBeat.o(63134);
            return true;
        } else {
            Log.i("MicroMsg.Music.WechatMusicLoadLibrary", "load library %s", str);
            a.class.getClassLoader();
            String dZ = j.dZ(str);
            if (!TextUtils.isEmpty(dZ)) {
                Log.i("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary find and load the lib %s so", dZ);
                j.Ed(str);
                AppMethodBeat.o(63134);
                return true;
            }
            Log.e("MicroMsg.Music.WechatMusicLoadLibrary", "LoadLibrary can't find the lib %s so", str);
            AppMethodBeat.o(63134);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.c
    public final String findLibPath(String str) {
        AppMethodBeat.i(63135);
        if (!str.startsWith(ShareConstants.SO_PATH)) {
            str = ShareConstants.SO_PATH.concat(String.valueOf(str));
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        AppMethodBeat.o(63135);
        return str;
    }

    @Override // com.tencent.mm.plugin.music.f.a.c
    public final boolean aHU(String str) {
        AppMethodBeat.i(63136);
        boolean Ee = j.Ee(str);
        AppMethodBeat.o(63136);
        return Ee;
    }
}
