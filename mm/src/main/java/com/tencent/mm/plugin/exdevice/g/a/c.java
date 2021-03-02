package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class c implements g.a {
    String appName = null;
    String rCh = null;

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        return null;
    }

    @Override // com.tencent.mm.i.g.a
    public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
        AppMethodBeat.i(23502);
        Log.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
        if (dVar == null || !str.equals(this.rCh)) {
            if (cVar != null) {
                Log.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i2 == 0 && dVar.field_retCode == 0) {
            Log.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            Log.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", str, dVar.toString());
            a aVar = new a();
            aVar.field_championUrl = dVar.field_fileUrl;
            aVar.field_username = z.aTY();
            b.anz(aVar.field_championUrl);
            ad.cKP().a(aVar);
            ad.cKT();
            bg.azz().a(new n(aVar.field_championUrl, aVar.field_championMotto), 0);
        } else {
            Log.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        AppMethodBeat.o(23502);
        return 0;
    }
}
