package com.tencent.mm.plugin.story.f;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert;", "", "()V", "Companion", "pullXml", "plugin-story_release"})
public final class p {
    public static final a FmN = new a((byte) 0);
    private static String INVALID_TAG = "]]>";
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$Companion;", "", "()V", "INVALID_TAG", "", "getINVALID_TAG", "()Ljava/lang/String;", "setINVALID_TAG", "(Ljava/lang/String;)V", "TAG", "filterId", "s", "filterNull", "isNumeric", "", "str", "pullTimeLineXml", "timeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(eek eek, edu edu) {
            LinkedList<String> linkedList;
            AppMethodBeat.i(222908);
            kotlin.g.b.p.h(eek, "timeLine");
            eds eds = edu != null ? edu.Nef : null;
            b bVar = new b();
            HashMap hashMap = new HashMap();
            bVar.startTag("StoryObject");
            bVar.startTag("id");
            if (eek.Id == null || eek.Id.equals("")) {
                bVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                bVar.setText(eek.Id);
            }
            bVar.endTag("id");
            if (eek.UserName != null) {
                bVar.startTag(ch.COL_USERNAME);
                bVar.text(eek.UserName);
                bVar.endTag(ch.COL_USERNAME);
            }
            bVar.startTag("createTime");
            bVar.text(String.valueOf(eek.CreateTime));
            bVar.endTag("createTime");
            bVar.startTag("scope");
            bVar.setText(eek.NeD);
            bVar.endTag("scope");
            bVar.startTag("featured");
            bVar.setText(eek.NeE);
            bVar.endTag("featured");
            bVar.startTag("report");
            bVar.startTag("publish_obj_id");
            String str = eek.NeC;
            if (str == null) {
                str = "";
            }
            bVar.text(str);
            bVar.endTag("publish_obj_id");
            Log.i(p.TAG, "report ".concat(String.valueOf(eds)));
            if (eds != null) {
                bVar.startTag("music");
                if (eds.Nea) {
                    bVar.startTag("req_id");
                    bVar.text(String.valueOf(eds.NdZ));
                    bVar.endTag("req_id");
                    bVar.startTag("id");
                    bVar.setText(eds.BOX);
                    bVar.endTag("id");
                    bVar.startTag(FirebaseAnalytics.b.INDEX);
                    bVar.setText(eds.Lsa);
                    bVar.endTag(FirebaseAnalytics.b.INDEX);
                }
                bVar.endTag("music");
                bVar.startTag("emojiList");
                LinkedList<String> linkedList2 = eds.Neb;
                kotlin.g.b.p.g(linkedList2, "editor.emojiMd5");
                for (T t : linkedList2) {
                    bVar.startTag("emoji");
                    kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                    bVar.text(t);
                    bVar.endTag("emoji");
                }
                bVar.endTag("emojiList");
                bVar.startTag("wordList");
                LinkedList<String> linkedList3 = eds.Nec;
                kotlin.g.b.p.g(linkedList3, "editor.wordText");
                for (T t2 : linkedList3) {
                    bVar.startTag("word");
                    kotlin.g.b.p.g(t2, LocaleUtil.ITALIAN);
                    bVar.text(t2);
                    bVar.endTag("word");
                }
                bVar.endTag("wordList");
                bVar.startTag("tip");
                String str2 = eds.HIK;
                if (str2 == null) {
                    str2 = "";
                }
                bVar.text(str2);
                bVar.endTag("tip");
            }
            bVar.endTag("report");
            bVar.startTag("ContentObject");
            bVar.startTag("title");
            bVar.text(filterNull(eek.NeB.Title));
            bVar.endTag("title");
            if (eek.NeB.LoV.size() > 0) {
                bVar.startTag("mediaList");
                Iterator<edt> it = eek.NeB.LoV.iterator();
                while (it.hasNext()) {
                    edt next = it.next();
                    bVar.startTag("media");
                    bVar.startTag("id");
                    String str3 = next.Id;
                    kotlin.g.b.p.g(str3, "media.Id");
                    if (kotlin.g.b.p.j(filterId(str3), "")) {
                        bVar.text(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    } else {
                        String str4 = next.Id;
                        kotlin.g.b.p.g(str4, "media.Id");
                        bVar.text(filterId(str4));
                    }
                    bVar.endTag("id");
                    bVar.startTag("type");
                    bVar.text(String.valueOf(next.oUv));
                    bVar.endTag("type");
                    bVar.startTag(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    bVar.sb.append(next.Ned);
                    bVar.endTag(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    hashMap.clear();
                    hashMap.put("type", String.valueOf(next.Mcw));
                    if (!Util.isNullOrNil(next.md5)) {
                        hashMap.put("md5", next.md5);
                    }
                    if (!Util.isNullOrNil(next.MsS)) {
                        hashMap.put("videomd5", next.MsS);
                    }
                    bVar.startTag("url", hashMap);
                    bVar.text(filterNull(next.Url));
                    bVar.endTag("url");
                    if (next.Msz != null && !next.Msz.equals("")) {
                        hashMap.clear();
                        hashMap.put("type", String.valueOf(next.MsA));
                        bVar.startTag("thumb", hashMap);
                        bVar.text(filterNull(next.Msz));
                        bVar.endTag("thumb");
                    }
                    if (next.subType > 0) {
                        bVar.startTag("subType");
                        bVar.text(String.valueOf(next.subType));
                        bVar.endTag("subType");
                    }
                    if (!Util.isNullOrNil(edu != null ? edu.Nei : null)) {
                        bVar.startTag("SrcPicMD5List");
                        if (!(edu == null || (linkedList = edu.Nei) == null)) {
                            for (T t3 : linkedList) {
                                if (!Util.isNullOrNil((String) t3)) {
                                    bVar.startTag("value");
                                    kotlin.g.b.p.g(t3, LocaleUtil.ITALIAN);
                                    bVar.text(t3);
                                    bVar.endTag("value");
                                }
                            }
                        }
                        bVar.endTag("SrcPicMD5List");
                    }
                    bVar.endTag("media");
                }
                bVar.endTag("mediaList");
            }
            bVar.endTag("ContentObject");
            bVar.endTag("StoryObject");
            String stringBuffer = bVar.sb.toString();
            kotlin.g.b.p.g(stringBuffer, "sb.toString()");
            Log.d(p.TAG, "xmlContent: ".concat(String.valueOf(stringBuffer)));
            if (XmlParser.parseXml(stringBuffer, "StoryObject", null) == null) {
                Log.e(p.TAG, "xml is error");
                AppMethodBeat.o(222908);
                return "";
            }
            AppMethodBeat.o(222908);
            return stringBuffer;
        }

        private static String filterNull(String str) {
            return str == null ? "" : str;
        }

        private static String filterId(String str) {
            AppMethodBeat.i(118759);
            kotlin.g.b.p.h(str, "s");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(118759);
                return "";
            } else if (isNumeric(str)) {
                AppMethodBeat.o(118759);
                return str;
            } else {
                AppMethodBeat.o(118759);
                return "";
            }
        }

        private static boolean isNumeric(String str) {
            AppMethodBeat.i(118760);
            kotlin.g.b.p.h(str, "str");
            boolean aJ = new k("\\d*").aJ(str);
            AppMethodBeat.o(118760);
            return aJ;
        }
    }

    static {
        AppMethodBeat.i(118768);
        AppMethodBeat.o(118768);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0018J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryTimelineConvert$pullXml;", "", "()V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "setSb", "(Ljava/lang/StringBuffer;)V", "xml", "", "getXml", "()Ljava/lang/String;", "addTag", "", "tag", "value", "", "emptyTag", "endTag", "setText", "", "startTag", "values", "", "text", "plugin-story_release"})
    public static final class b {
        StringBuffer sb = new StringBuffer();

        public b() {
            AppMethodBeat.i(118767);
            AppMethodBeat.o(118767);
        }

        public final void startTag(String str) {
            AppMethodBeat.i(118761);
            kotlin.g.b.p.h(str, "tag");
            this.sb.append("<" + str + '>');
            AppMethodBeat.o(118761);
        }

        public final void endTag(String str) {
            AppMethodBeat.i(118762);
            kotlin.g.b.p.h(str, "tag");
            this.sb.append("</" + str + '>');
            AppMethodBeat.o(118762);
        }

        public final void text(String str) {
            AppMethodBeat.i(118763);
            kotlin.g.b.p.h(str, "value");
            setText(str);
            AppMethodBeat.o(118763);
        }

        public final void setText(String str) {
            AppMethodBeat.i(118764);
            kotlin.g.b.p.h(str, "value");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(118764);
                return;
            }
            a aVar = p.FmN;
            if (n.a((CharSequence) str, (CharSequence) p.INVALID_TAG, false)) {
                this.sb.append("<![CDATA[" + Util.escapeStringForXml(str) + "]]>");
                AppMethodBeat.o(118764);
                return;
            }
            this.sb.append("<![CDATA[" + str + "]]>");
            AppMethodBeat.o(118764);
        }

        public final void setText(int i2) {
            AppMethodBeat.i(118765);
            this.sb.append(i2);
            AppMethodBeat.o(118765);
        }

        public final void startTag(String str, Map<String, String> map) {
            AppMethodBeat.i(118766);
            kotlin.g.b.p.h(str, "tag");
            kotlin.g.b.p.h(map, "values");
            this.sb.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.sb.append(" " + str2 + "=\"" + map.get(str2) + "\" ");
            }
            this.sb.append(">");
            map.clear();
            AppMethodBeat.o(118766);
        }
    }
}
