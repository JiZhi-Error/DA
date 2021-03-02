package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q {
    public static final a FmO = new a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
    public static final class d {
        private static final String Fni = Fni;
        private static final String Fnj = Fnj;
        private static final String Fnk = Fnk;
        private static final String Fnl = Fnl;
        private static final String Fnm = Fnm;
        private static final String Fnn = Fnn;
        private static final String Fno = Fno;
        public static final d Fnp = new d();

        static {
            AppMethodBeat.i(118775);
            AppMethodBeat.o(118775);
        }

        private d() {
        }

        public static String foL() {
            return Fni;
        }

        public static String foM() {
            return Fnj;
        }

        public static String foN() {
            return Fnk;
        }

        public static String foO() {
            return Fnn;
        }

        public static String foP() {
            return Fno;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$ContentObjTAG;", "", "()V", "XML_MEDIALIST", "", "getXML_MEDIALIST", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        private static final String FmP = FmP;
        public static final b FmQ = new b();

        static {
            AppMethodBeat.i(118773);
            AppMethodBeat.o(118773);
        }

        private b() {
        }

        public static String foy() {
            return FmP;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$MediaObjTAG;", "", "()V", "XML_DESC", "", "getXML_DESC", "()Ljava/lang/String;", "XML_DURATION", "getXML_DURATION", "XML_PRIVATED", "getXML_PRIVATED", "XML_SIZE", "getXML_SIZE", "XML_SUBTYPE", "getXML_SUBTYPE", "XML_TAG", "getXML_TAG", "XML_THUMB", "getXML_THUMB", "XML_THUMBTYPE", "getXML_THUMBTYPE", "XML_TITLE", "getXML_TITLE", "XML_TYPE", "getXML_TYPE", "XML_URL", "getXML_URL", "XML_URLTYPE", "getXML_URLTYPE", "XML_URL_MD5", "getXML_URL_MD5", "XML_USERDATA", "getXML_USERDATA", "XML_VIDEOMD5", "getXML_VIDEOMD5", "XML_id", "getXML_id", "plugin-story_release"})
    public static final class c {
        private static final String FmR = FmR;
        private static final String FmS = FmS;
        private static final String FmT = FmT;
        private static final String FmU = FmU;
        private static final String FmV = FmV;
        private static final String FmW = FmW;
        private static final String FmX = FmX;
        private static final String FmY = FmY;
        private static final String FmZ = FmZ;
        private static final String Fna = Fna;
        private static final String Fnb = Fnb;
        private static final String Fnc = Fnc;
        private static final String Fnd = Fnd;
        private static final String Fne = Fne;
        private static final String Fnf = Fnf;
        private static final String Fng = Fng;
        public static final c Fnh = new c();

        static {
            AppMethodBeat.i(118774);
            AppMethodBeat.o(118774);
        }

        private c() {
        }

        public static String foz() {
            return FmR;
        }

        public static String foA() {
            return FmS;
        }

        public static String foB() {
            return FmT;
        }

        public static String foC() {
            return FmW;
        }

        public static String foD() {
            return FmX;
        }

        public static String foE() {
            return FmY;
        }

        public static String foF() {
            return FmZ;
        }

        public static String foG() {
            return Fna;
        }

        public static String foH() {
            return Fnd;
        }

        public static String foI() {
            return Fne;
        }

        public static String foJ() {
            return Fnf;
        }

        public static String foK() {
            return Fng;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J$\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJL\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fillContentObj", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "maps", "", "timeLine", "fillLocation", "getMediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "srcMedia", "id", "mediaType", "", "mediaUrl", "mediaThumb", "mediaUrlType", "mediaThumbType", "desc", "isPrivated", "getNewTimeline", "parserFloat", "", "src", "parserFromXml", "xml", "parserInt", "parserLong", "", "parserString", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static eek a(eek eek) {
            AppMethodBeat.i(118769);
            dlg dlg = new dlg();
            dlg.LbC = 0.0f;
            dlg.LbD = 0.0f;
            dlg.kea = "";
            dlg.Mpu = 0;
            dlg.LIb = "";
            dlg.Esb = 0;
            dlg.ErZ = "";
            dlg.kHV = "";
            dlg.Mpv = 1;
            dlg.Mpx = "";
            dlg.country = "";
            eek.NeA = dlg;
            AppMethodBeat.o(118769);
            return eek;
        }

        private static eek a(Map<String, String> map, eek eek) {
            String sb;
            String sb2;
            String sb3;
            String sb4;
            String sb5;
            String sb6;
            String sb7;
            String sb8;
            String sb9;
            String sb10;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            float f2;
            AppMethodBeat.i(118770);
            if (eek.NeB == null) {
                eek.NeB = new edk();
            }
            eek.NeB.Title = PL(map.get("contTitle"));
            int i2 = 0;
            while (true) {
                if (i2 != 0) {
                    StringBuilder sb11 = new StringBuilder();
                    d dVar = d.Fnp;
                    StringBuilder append = sb11.append(d.foO());
                    b bVar = b.FmQ;
                    StringBuilder append2 = append.append(b.foy());
                    c cVar = c.Fnh;
                    StringBuilder append3 = append2.append(c.foz()).append(i2);
                    c cVar2 = c.Fnh;
                    sb = append3.append(c.foA()).toString();
                    StringBuilder sb12 = new StringBuilder();
                    d dVar2 = d.Fnp;
                    StringBuilder append4 = sb12.append(d.foO());
                    b bVar2 = b.FmQ;
                    StringBuilder append5 = append4.append(b.foy());
                    c cVar3 = c.Fnh;
                    StringBuilder append6 = append5.append(c.foz()).append(i2);
                    c cVar4 = c.Fnh;
                    sb2 = append6.append(c.foB()).toString();
                    StringBuilder sb13 = new StringBuilder();
                    d dVar3 = d.Fnp;
                    StringBuilder append7 = sb13.append(d.foO());
                    b bVar3 = b.FmQ;
                    StringBuilder append8 = append7.append(b.foy());
                    c cVar5 = c.Fnh;
                    StringBuilder append9 = append8.append(c.foz()).append(i2);
                    c cVar6 = c.Fnh;
                    sb3 = append9.append(c.foC()).toString();
                    StringBuilder sb14 = new StringBuilder();
                    d dVar4 = d.Fnp;
                    StringBuilder append10 = sb14.append(d.foO());
                    b bVar4 = b.FmQ;
                    StringBuilder append11 = append10.append(b.foy());
                    c cVar7 = c.Fnh;
                    StringBuilder append12 = append11.append(c.foz()).append(i2);
                    c cVar8 = c.Fnh;
                    sb4 = append12.append(c.foD()).toString();
                    StringBuilder sb15 = new StringBuilder();
                    d dVar5 = d.Fnp;
                    StringBuilder append13 = sb15.append(d.foO());
                    b bVar5 = b.FmQ;
                    StringBuilder append14 = append13.append(b.foy());
                    c cVar9 = c.Fnh;
                    StringBuilder append15 = append14.append(c.foz()).append(i2);
                    c cVar10 = c.Fnh;
                    sb5 = append15.append(c.foF()).toString();
                    StringBuilder sb16 = new StringBuilder();
                    d dVar6 = d.Fnp;
                    StringBuilder append16 = sb16.append(d.foO());
                    b bVar6 = b.FmQ;
                    StringBuilder append17 = append16.append(b.foy());
                    c cVar11 = c.Fnh;
                    StringBuilder append18 = append17.append(c.foz()).append(i2);
                    c cVar12 = c.Fnh;
                    sb6 = append18.append(c.foE()).toString();
                    StringBuilder sb17 = new StringBuilder();
                    d dVar7 = d.Fnp;
                    StringBuilder append19 = sb17.append(d.foO());
                    b bVar7 = b.FmQ;
                    StringBuilder append20 = append19.append(b.foy());
                    c cVar13 = c.Fnh;
                    StringBuilder append21 = append20.append(c.foz()).append(i2);
                    c cVar14 = c.Fnh;
                    sb7 = append21.append(c.foG()).toString();
                    StringBuilder sb18 = new StringBuilder();
                    d dVar8 = d.Fnp;
                    StringBuilder append22 = sb18.append(d.foO());
                    b bVar8 = b.FmQ;
                    StringBuilder append23 = append22.append(b.foy());
                    c cVar15 = c.Fnh;
                    StringBuilder append24 = append23.append(c.foz()).append(i2);
                    c cVar16 = c.Fnh;
                    sb8 = append24.append(c.foH()).toString();
                    StringBuilder sb19 = new StringBuilder();
                    d dVar9 = d.Fnp;
                    StringBuilder append25 = sb19.append(d.foO());
                    b bVar9 = b.FmQ;
                    StringBuilder append26 = append25.append(b.foy());
                    c cVar17 = c.Fnh;
                    StringBuilder append27 = append26.append(c.foz()).append(i2);
                    c cVar18 = c.Fnh;
                    sb9 = append27.append(c.foI()).toString();
                    StringBuilder sb20 = new StringBuilder();
                    d dVar10 = d.Fnp;
                    StringBuilder append28 = sb20.append(d.foO());
                    b bVar10 = b.FmQ;
                    StringBuilder append29 = append28.append(b.foy());
                    c cVar19 = c.Fnh;
                    append29.append(c.foz()).append(i2);
                    StringBuilder sb21 = new StringBuilder();
                    d dVar11 = d.Fnp;
                    StringBuilder append30 = sb21.append(d.foO());
                    b bVar11 = b.FmQ;
                    StringBuilder append31 = append30.append(b.foy());
                    c cVar20 = c.Fnh;
                    StringBuilder append32 = append31.append(c.foz()).append(i2);
                    c cVar21 = c.Fnh;
                    String sb22 = append32.append(c.foJ()).toString();
                    StringBuilder sb23 = new StringBuilder();
                    d dVar12 = d.Fnp;
                    StringBuilder append33 = sb23.append(d.foO());
                    b bVar12 = b.FmQ;
                    StringBuilder append34 = append33.append(b.foy());
                    c cVar22 = c.Fnh;
                    StringBuilder append35 = append34.append(c.foz()).append(i2);
                    c cVar23 = c.Fnh;
                    sb10 = append35.append(c.foK()).toString();
                    str = sb22;
                } else {
                    StringBuilder sb24 = new StringBuilder();
                    d dVar13 = d.Fnp;
                    StringBuilder append36 = sb24.append(d.foO());
                    b bVar13 = b.FmQ;
                    StringBuilder append37 = append36.append(b.foy());
                    c cVar24 = c.Fnh;
                    StringBuilder append38 = append37.append(c.foz());
                    c cVar25 = c.Fnh;
                    sb = append38.append(c.foA()).toString();
                    StringBuilder sb25 = new StringBuilder();
                    d dVar14 = d.Fnp;
                    StringBuilder append39 = sb25.append(d.foO());
                    b bVar14 = b.FmQ;
                    StringBuilder append40 = append39.append(b.foy());
                    c cVar26 = c.Fnh;
                    StringBuilder append41 = append40.append(c.foz());
                    c cVar27 = c.Fnh;
                    sb2 = append41.append(c.foB()).toString();
                    StringBuilder sb26 = new StringBuilder();
                    d dVar15 = d.Fnp;
                    StringBuilder append42 = sb26.append(d.foO());
                    b bVar15 = b.FmQ;
                    StringBuilder append43 = append42.append(b.foy());
                    c cVar28 = c.Fnh;
                    StringBuilder append44 = append43.append(c.foz());
                    c cVar29 = c.Fnh;
                    sb3 = append44.append(c.foC()).toString();
                    StringBuilder sb27 = new StringBuilder();
                    d dVar16 = d.Fnp;
                    StringBuilder append45 = sb27.append(d.foO());
                    b bVar16 = b.FmQ;
                    StringBuilder append46 = append45.append(b.foy());
                    c cVar30 = c.Fnh;
                    StringBuilder append47 = append46.append(c.foz());
                    c cVar31 = c.Fnh;
                    sb4 = append47.append(c.foD()).toString();
                    StringBuilder sb28 = new StringBuilder();
                    d dVar17 = d.Fnp;
                    StringBuilder append48 = sb28.append(d.foO());
                    b bVar17 = b.FmQ;
                    StringBuilder append49 = append48.append(b.foy());
                    c cVar32 = c.Fnh;
                    StringBuilder append50 = append49.append(c.foz());
                    c cVar33 = c.Fnh;
                    sb5 = append50.append(c.foF()).toString();
                    StringBuilder sb29 = new StringBuilder();
                    d dVar18 = d.Fnp;
                    StringBuilder append51 = sb29.append(d.foO());
                    b bVar18 = b.FmQ;
                    StringBuilder append52 = append51.append(b.foy());
                    c cVar34 = c.Fnh;
                    StringBuilder append53 = append52.append(c.foz());
                    c cVar35 = c.Fnh;
                    sb6 = append53.append(c.foE()).toString();
                    StringBuilder sb30 = new StringBuilder();
                    d dVar19 = d.Fnp;
                    StringBuilder append54 = sb30.append(d.foO());
                    b bVar19 = b.FmQ;
                    StringBuilder append55 = append54.append(b.foy());
                    c cVar36 = c.Fnh;
                    StringBuilder append56 = append55.append(c.foz());
                    c cVar37 = c.Fnh;
                    sb7 = append56.append(c.foG()).toString();
                    StringBuilder sb31 = new StringBuilder();
                    d dVar20 = d.Fnp;
                    StringBuilder append57 = sb31.append(d.foO());
                    b bVar20 = b.FmQ;
                    StringBuilder append58 = append57.append(b.foy());
                    c cVar38 = c.Fnh;
                    StringBuilder append59 = append58.append(c.foz());
                    c cVar39 = c.Fnh;
                    sb8 = append59.append(c.foH()).toString();
                    StringBuilder sb32 = new StringBuilder();
                    d dVar21 = d.Fnp;
                    StringBuilder append60 = sb32.append(d.foO());
                    b bVar21 = b.FmQ;
                    StringBuilder append61 = append60.append(b.foy());
                    c cVar40 = c.Fnh;
                    StringBuilder append62 = append61.append(c.foz());
                    c cVar41 = c.Fnh;
                    sb9 = append62.append(c.foI()).toString();
                    StringBuilder sb33 = new StringBuilder();
                    d dVar22 = d.Fnp;
                    StringBuilder append63 = sb33.append(d.foO());
                    b bVar22 = b.FmQ;
                    StringBuilder append64 = append63.append(b.foy());
                    c cVar42 = c.Fnh;
                    append64.append(c.foz());
                    StringBuilder sb34 = new StringBuilder();
                    d dVar23 = d.Fnp;
                    StringBuilder append65 = sb34.append(d.foO());
                    b bVar23 = b.FmQ;
                    StringBuilder append66 = append65.append(b.foy());
                    c cVar43 = c.Fnh;
                    StringBuilder append67 = append66.append(c.foz());
                    c cVar44 = c.Fnh;
                    String sb35 = append67.append(c.foJ()).toString();
                    StringBuilder sb36 = new StringBuilder();
                    d dVar24 = d.Fnp;
                    StringBuilder append68 = sb36.append(d.foO());
                    b bVar24 = b.FmQ;
                    StringBuilder append69 = append68.append(b.foy());
                    c cVar45 = c.Fnh;
                    StringBuilder append70 = append69.append(c.foz());
                    c cVar46 = c.Fnh;
                    sb10 = append70.append(c.foK()).toString();
                    str = sb35;
                }
                String str10 = map.get(sb);
                String str11 = map.get(sb2);
                if (str11 == null) {
                    str2 = "";
                } else {
                    str2 = str11;
                }
                String str12 = map.get(sb3);
                if (str12 == null) {
                    str3 = "";
                } else {
                    str3 = str12;
                }
                String str13 = map.get(sb5);
                if (str13 == null) {
                    str4 = "";
                } else {
                    str4 = str13;
                }
                String str14 = map.get(sb4);
                if (str14 == null) {
                    str5 = "";
                } else {
                    str5 = str14;
                }
                String str15 = map.get(sb6);
                if (str15 == null) {
                    str6 = "";
                } else {
                    str6 = str15;
                }
                String str16 = map.get(sb7);
                if (str16 == null) {
                    str7 = "";
                } else {
                    str7 = str16;
                }
                String str17 = map.get(sb8);
                if (str17 == null) {
                    str8 = "";
                } else {
                    str8 = str17;
                }
                map.get(sb9);
                String str18 = map.get(str);
                if (str18 == null) {
                    str9 = "";
                } else {
                    str9 = str18;
                }
                String str19 = map.get(sb10);
                if (str19 == null) {
                    str19 = "";
                }
                if (str2 == null || str10 == null) {
                    AppMethodBeat.o(118770);
                } else {
                    edt edt = new edt();
                    edt.Id = PL(str10);
                    edt.oUv = Util.getInt(str2, 0);
                    edt.Url = PL(str3);
                    edt.Mcw = Util.getInt(str6, 0);
                    edt.Msz = PL(str4);
                    edt.MsA = Util.getInt(str7, 0);
                    edt.subType = Util.getInt(str8, 0);
                    edt.md5 = PL(str9);
                    edt.MsS = PL(str5);
                    if (str19 == null) {
                        f2 = 0.0f;
                    } else {
                        f2 = Util.getFloat(str19, 0.0f);
                    }
                    edt.Ned = f2;
                    eek.NeB.LoV.add(edt);
                    i2++;
                }
            }
            AppMethodBeat.o(118770);
            return eek;
        }

        public static eek fox() {
            AppMethodBeat.i(118771);
            eek eek = new eek();
            edk edk = new edk();
            dlg dlg = new dlg();
            dlg.LbD = 0.0f;
            dlg.LbC = 0.0f;
            eek.NeA = dlg;
            eek.NeB = edk;
            eek.Id = "";
            eek.CreateTime = 0;
            AppMethodBeat.o(118771);
            return eek;
        }

        private static String PL(String str) {
            return str == null ? "" : str;
        }

        public static eek aSb(String str) {
            AppMethodBeat.i(118772);
            p.h(str, "xml");
            Map<String, String> parseXml = XmlParser.parseXml(str, "StoryObject", null);
            if (parseXml != null) {
                eek fox = fox();
                d dVar = d.Fnp;
                fox.Id = PL(parseXml.get(d.foL()));
                d dVar2 = d.Fnp;
                fox.UserName = PL(parseXml.get(d.foM()));
                d dVar3 = d.Fnp;
                fox.CreateTime = Util.getInt(parseXml.get(d.foN()), 0);
                d dVar4 = d.Fnp;
                fox.NeD = Util.getInt(parseXml.get(d.foP()), 0);
                eek a2 = a(parseXml, a(fox));
                AppMethodBeat.o(118772);
                return a2;
            }
            AppMethodBeat.o(118772);
            return null;
        }
    }

    static {
        AppMethodBeat.i(118776);
        AppMethodBeat.o(118776);
    }
}
