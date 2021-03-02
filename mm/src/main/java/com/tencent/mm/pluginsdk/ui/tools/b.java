package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b extends f {
    public int Alz = 0;
    public String Ktn = "";
    public String Kto = "";
    public String Ktp = "";
    public String Ktq = "";
    public String Ktr = "";
    public String Kts = "";
    public String Ktt = "";
    public String Ktu = "";
    public String Ktv = "";
    public String Ktw = "";
    public String songAlbumUrl = "";
    public String songLyric = "";

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(152371);
        b bVar = new b();
        bVar.songAlbumUrl = this.songAlbumUrl;
        bVar.songLyric = this.songLyric;
        bVar.Ktn = this.Ktn;
        bVar.Kto = this.Kto;
        bVar.Ktp = this.Ktp;
        bVar.Ktq = this.Ktq;
        bVar.Ktr = this.Ktr;
        bVar.Kts = this.Kts;
        bVar.Ktt = this.Ktt;
        bVar.Ktu = this.Ktu;
        bVar.Ktv = this.Ktv;
        bVar.Ktw = this.Ktw;
        bVar.Alz = this.Alz;
        AppMethodBeat.o(152371);
        return bVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(152372);
        if (!Util.isNullOrNil(this.songAlbumUrl)) {
            sb.append("<songalbumurl>").append(Util.escapeStringForXml(this.songAlbumUrl)).append("</songalbumurl>");
        }
        if (!Util.isNullOrNil(this.songLyric)) {
            sb.append("<songlyric>").append(Util.escapeStringForXml(this.songLyric)).append("</songlyric>");
        }
        sb.append("<musicShareItem>");
        if (!Util.isNullOrNil(this.Ktn)) {
            sb.append("<mvObjectId>").append(Util.escapeStringForXml(this.Ktn)).append("</mvObjectId>");
        }
        if (!Util.isNullOrNil(this.Kto)) {
            sb.append("<mvNonceId>").append(Util.escapeStringForXml(this.Kto)).append("</mvNonceId>");
        }
        if (!Util.isNullOrNil(this.Ktp)) {
            sb.append("<mvCoverUrl>").append(Util.escapeStringForXml(this.Ktp)).append("</mvCoverUrl>");
        }
        if (!Util.isNullOrNil(this.Ktq)) {
            sb.append("<mvMakerFinderNickname>").append(Util.escapeStringForXml(this.Ktq)).append("</mvMakerFinderNickname>");
        }
        if (!Util.isNullOrNil(this.Ktr)) {
            sb.append("<mvSingerName>").append(Util.escapeStringForXml(this.Ktr)).append("</mvSingerName>");
        }
        if (!Util.isNullOrNil(this.Kts)) {
            sb.append("<mvAlbumName>").append(Util.escapeStringForXml(this.Kts)).append("</mvAlbumName>");
        }
        if (!Util.isNullOrNil(this.Ktt)) {
            sb.append("<mvMusicGenre>").append(Util.escapeStringForXml(this.Ktt)).append("</mvMusicGenre>");
        }
        if (!Util.isNullOrNil(this.Ktu)) {
            sb.append("<mvIssueDate>").append(Util.escapeStringForXml(this.Ktu)).append("</mvIssueDate>");
        }
        if (!Util.isNullOrNil(this.Ktv)) {
            sb.append("<mvIdentification>").append(Util.escapeStringForXml(this.Ktv)).append("</mvIdentification>");
        }
        sb.append("<musicDuration>").append(this.Alz).append("</musicDuration>");
        if (!Util.isNullOrNil(this.Ktw)) {
            sb.append("<mvExtInfo>").append(Util.escapeStringForXml(this.Ktw)).append("</mvExtInfo>");
        }
        sb.append("</musicShareItem>");
        AppMethodBeat.o(152372);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(152373);
        this.songAlbumUrl = map.get(".msg.appmsg.songalbumurl");
        this.songLyric = map.get(".msg.appmsg.songlyric");
        this.Ktn = map.get(".msg.appmsg.musicShareItem.mvObjectId");
        this.Kto = map.get(".msg.appmsg.musicShareItem.mvNonceId");
        this.Ktp = map.get(".msg.appmsg.musicShareItem.mvCoverUrl");
        this.Ktq = map.get(".msg.appmsg.musicShareItem.mvMakerFinderNickname");
        this.Ktr = map.get(".msg.appmsg.musicShareItem.mvSingerName");
        this.Kts = map.get(".msg.appmsg.musicShareItem.mvAlbumName");
        this.Ktt = map.get(".msg.appmsg.musicShareItem.mvMusicGenre");
        this.Ktu = map.get(".msg.appmsg.musicShareItem.mvIssueDate");
        this.Ktv = map.get(".msg.appmsg.musicShareItem.mvIdentification");
        this.Ktw = map.get(".msg.appmsg.musicShareItem.mvExtInfo");
        this.Alz = Util.safeParseInt(map.get(".msg.appmsg.musicShareItem.musicDuration"));
        AppMethodBeat.o(152373);
    }
}
