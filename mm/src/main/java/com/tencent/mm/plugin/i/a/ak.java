package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class ak {
    public static String a(css css) {
        AppMethodBeat.i(196084);
        StringBuilder sb = new StringBuilder();
        if (css != null) {
            try {
                sb.append("<musicShareItem><mvObjectId>").append(Util.escapeStringForXml(css.Ktn)).append("</mvObjectId><mvNonceId>").append(Util.escapeStringForXml(css.Kto)).append("</mvNonceId><mvCoverUrl>").append(Util.escapeStringForXml(css.Ktp)).append("</mvCoverUrl><mvMakerFinderNickname>").append(Util.escapeStringForXml(css.Ktq)).append("</mvMakerFinderNickname><mvSingerName>").append(Util.escapeStringForXml(css.singerName)).append("</mvSingerName><mvAlbumName>").append(Util.escapeStringForXml(css.albumName)).append("</mvAlbumName><mvMusicGenre>").append(Util.escapeStringForXml(css.musicGenre)).append("</mvMusicGenre><mvIssueDate>").append(css.issueDate).append("</mvIssueDate><mvIdentification>").append(Util.escapeStringForXml(css.identification)).append("</mvIdentification><musicDuration>").append(css.Alz).append("</musicDuration><mvExtInfo>").append(css.extraInfo).append("</mvExtInfo>");
                sb.append("</musicShareItem>");
            } catch (Exception e2) {
                Log.e("MicroMsg.MusicMvShareParser", "make content error! %s", e2.getMessage());
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(196084);
        return sb2;
    }

    public static css C(String str, Map<String, String> map) {
        AppMethodBeat.i(196085);
        css css = new css();
        try {
            String str2 = str + ".musicShareItem";
            if (!map.isEmpty()) {
                css.Ktn = Util.nullAsNil(map.get(str2 + ".mvObjectId"));
                css.Kto = Util.nullAsNil(map.get(str2 + ".mvNonceId"));
                css.Ktp = Util.nullAsNil(map.get(str2 + ".mvCoverUrl"));
                css.Ktq = Util.nullAsNil(map.get(str2 + ".mvMakerFinderNickname"));
                css.singerName = Util.nullAsNil(map.get(str2 + ".mvSingerName"));
                css.albumName = Util.nullAsNil(map.get(str2 + ".mvAlbumName"));
                css.musicGenre = Util.nullAsNil(map.get(str2 + ".mvMusicGenre"));
                css.issueDate = Util.safeParseLong(map.get(str2 + ".mvIssueDate"));
                css.identification = Util.nullAsNil(map.get(str2 + ".mvIdentification"));
                css.Alz = Util.safeParseInt(map.get(str2 + ".musicDuration"));
                css.extraInfo = Util.nullAsNil(map.get(str2 + ".mvExtInfo"));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MusicMvShareParser", "parse error! %s", e2.getMessage());
        }
        AppMethodBeat.o(196085);
        return css;
    }
}
