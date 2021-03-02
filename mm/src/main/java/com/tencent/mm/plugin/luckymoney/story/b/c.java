package com.tencent.mm.plugin.luckymoney.story.b;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends ej {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public static c a(edn edn, String str) {
        AppMethodBeat.i(163694);
        c cVar = new c();
        if (edn != null) {
            cVar.field_packet_id = str;
            cVar.field_height = edn.height;
            cVar.field_width = edn.width;
            cVar.field_media_type = edn.Gat;
            cVar.field_media_md5 = edn.NdO;
            cVar.field_media_url = edn.Gav;
            cVar.field_media_fuzzy_thumbnail_url = edn.NdP;
            cVar.field_media_fuzzy_thumbnail_md5 = edn.NdQ;
        }
        AppMethodBeat.o(163694);
        return cVar;
    }

    public static edn a(c cVar) {
        AppMethodBeat.i(163695);
        edn edn = new edn();
        edn.height = cVar.field_height;
        edn.width = cVar.field_width;
        edn.Gat = cVar.field_media_type;
        edn.Gav = cVar.field_media_url;
        edn.NdO = cVar.field_media_md5;
        edn.NdP = cVar.field_media_fuzzy_thumbnail_url;
        edn.NdQ = cVar.field_media_fuzzy_thumbnail_md5;
        AppMethodBeat.o(163695);
        return edn;
    }

    static {
        AppMethodBeat.i(163696);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[8];
        mAutoDBInfo.columns = new String[9];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = MessengerShareContentUtility.MEDIA_TYPE;
        mAutoDBInfo.colsMap.put(MessengerShareContentUtility.MEDIA_TYPE, "INTEGER");
        sb.append(" media_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "media_url";
        mAutoDBInfo.colsMap.put("media_url", "TEXT");
        sb.append(" media_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "media_md5";
        mAutoDBInfo.colsMap.put("media_md5", "TEXT");
        sb.append(" media_md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "height";
        mAutoDBInfo.colsMap.put("height", "INTEGER");
        sb.append(" height INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "width";
        mAutoDBInfo.colsMap.put("width", "INTEGER");
        sb.append(" width INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "packet_id";
        mAutoDBInfo.colsMap.put("packet_id", "TEXT");
        sb.append(" packet_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "media_fuzzy_thumbnail_url";
        mAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_url", "TEXT");
        sb.append(" media_fuzzy_thumbnail_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "media_fuzzy_thumbnail_md5";
        mAutoDBInfo.colsMap.put("media_fuzzy_thumbnail_md5", "TEXT");
        sb.append(" media_fuzzy_thumbnail_md5 TEXT");
        mAutoDBInfo.columns[8] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(163696);
    }
}
