package com.tencent.mm.plugin.story.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.PluginVideoEditor;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001d\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001d\u0010\r\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J/\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J%\u0010\u001a\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u001d\u0010 \u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010!\u001a\u00020\u0004H\u0002¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "resetI2VParams", "(Landroid/content/Context;[Ljava/lang/String;)V", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a FlX = new a((byte) 0);

    static {
        AppMethodBeat.i(118663);
        AppMethodBeat.o(118663);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestI2V", "TestMakeData", "TestResetFirst", "TestResetI2V", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        String str2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        SharedPreferences.Editor putInt2;
        SharedPreferences.Editor putInt3;
        SharedPreferences.Editor putInt4;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putInt5;
        SharedPreferences.Editor putInt6;
        SharedPreferences.Editor putInt7;
        SharedPreferences.Editor putInt8;
        SharedPreferences sharedPreferences = null;
        AppMethodBeat.i(118654);
        p.h(strArr, "args");
        p.h(str, ch.COL_USERNAME);
        Log.i("MicroMsg.StoryCommand", e.a(strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63));
        if (strArr.length <= 1) {
            AppMethodBeat.o(118654);
            return false;
        }
        String str3 = strArr[1];
        switch (str3.hashCode()) {
            case -2127268982:
                if (str3.equals("strangerDump")) {
                    j.b bVar = j.Fmy;
                    for (T t : j.b.fod().frv()) {
                        Log.i("MicroMsg.StoryCommand", "strangerDump " + t.getUserName() + ' ' + ((f) t).field_syncId + ' ' + ((f) t).field_readId + ' ' + ((f) t).field_storyPostTime + ' ' + ((f) t).field_updateTime);
                    }
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -2126867668:
                if (str3.equals("strangerRead")) {
                    j.b bVar2 = j.Fmy;
                    for (T t2 : j.b.fod().frv()) {
                        ((f) t2).field_readId = ((f) t2).field_syncId;
                        j.b bVar3 = j.Fmy;
                        j.b.fod().b(t2);
                    }
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -2122675824:
                if (str3.equals("dumpFile")) {
                    l lVar = l.FmK;
                    l.fot();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -2113815067:
                if (str3.equals("testcopyDb")) {
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.kernel.e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    String sb2 = sb.append(aAh.azM()).append("StoryMicroMsg.db").toString();
                    StringBuilder sb3 = new StringBuilder();
                    j.b bVar4 = j.Fmy;
                    String sb4 = sb3.append(j.b.getAccStoryPath()).append("StoryMicroMsg.db").toString();
                    s.nw(sb2, sb4);
                    Log.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(sb4)));
                    u.makeText(MMApplicationContext.getContext(), "copydb done", 1).show();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -1699823967:
                if (str3.equals("resetFirst")) {
                    com.tencent.mm.kernel.e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_STORY_BUBBLE_COUNT_INT, (Object) 0);
                    com.tencent.mm.kernel.e aAh3 = g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(ar.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                    com.tencent.mm.kernel.e aAh4 = g.aAh();
                    p.g(aAh4, "MMKernel.storage()");
                    aAh4.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -1522028681:
                if (str3.equals("strangerClear")) {
                    j.b bVar5 = j.Fmy;
                    Iterator<T> it = j.b.fod().frC().iterator();
                    while (it.hasNext()) {
                        j.b bVar6 = j.Fmy;
                        j.b.fod().delete(it.next(), new String[0]);
                    }
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -1408241804:
                if (str3.equals("testDumpInfo")) {
                    j.b bVar7 = j.Fmy;
                    Cursor rawQuery = j.b.fog().db.rawQuery("select count(*) from StoryVideoCacheInfo", null);
                    p.g(rawQuery, "cu");
                    int count = rawQuery.getCount();
                    rawQuery.close();
                    String concat = "StoryVideoCacheInfo resultData ".concat(String.valueOf(count));
                    j.b bVar8 = j.Fmy;
                    Cursor rawQuery2 = j.b.foc().db.rawQuery("select count(*) from " + k.TABLE, null);
                    p.g(rawQuery2, "cu");
                    int count2 = rawQuery2.getCount();
                    rawQuery2.close();
                    Log.i("MicroMsg.StoryCommand", "info1 " + concat + " info2 " + (k.TABLE + " resultData " + count2));
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -534114059:
                if (str3.equals("allmockData")) {
                    Q(strArr);
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -505421199:
                if (str3.equals("copyfile")) {
                    String str4 = strArr[2];
                    l lVar2 = l.FmK;
                    l.fot();
                    l lVar3 = l.FmK;
                    p.h(str4, "path");
                    l.aLP(l.m31for() + "cpfiles/");
                    o oVar = new o(str4);
                    if (!oVar.exists()) {
                        str2 = "";
                    } else {
                        str2 = l.m31for() + "cpfiles/" + oVar.getName();
                        Log.i("MicroMsg.StoryFileNameUtil", "copy file path " + str4 + " newPath " + str2);
                        s.nw(str4, str2);
                    }
                    u.makeText(MMApplicationContext.getContext(), "copyFile done ".concat(String.valueOf(str2)), 1).show();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case -350339842:
                if (str3.equals("reseti2v")) {
                    if (context != null) {
                        sharedPreferences = context.getSharedPreferences("storyi2v", 0);
                    }
                    if (!(sharedPreferences == null || (edit2 = sharedPreferences.edit()) == null || (putInt5 = edit2.putInt("storyi2v_bitRate", 3500000)) == null || (putInt6 = putInt5.putInt("storyi2v_frameRate", 15)) == null || (putInt7 = putInt6.putInt("storyi2v_iFrameInterval", 10)) == null || (putInt8 = putInt7.putInt("storyi2v_MaxSize", TAVExporter.VIDEO_EXPORT_WIDTH)) == null)) {
                        putInt8.commit();
                    }
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 102573:
                if (str3.equals("i2v")) {
                    p.h(strArr, "args");
                    int safeParseInt = Util.safeParseInt(strArr[2]);
                    int safeParseInt2 = Util.safeParseInt(strArr[3]);
                    int safeParseInt3 = Util.safeParseInt(strArr[4]);
                    int safeParseInt4 = Util.safeParseInt(strArr[5]);
                    if (context != null) {
                        sharedPreferences = context.getSharedPreferences("storyi2v", 0);
                    }
                    if (!(sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putInt = edit.putInt("storyi2v_bitRate", safeParseInt)) == null || (putInt2 = putInt.putInt("storyi2v_frameRate", safeParseInt2)) == null || (putInt3 = putInt2.putInt("storyi2v_iFrameInterval", safeParseInt3)) == null || (putInt4 = putInt3.putInt("storyi2v_MaxSize", safeParseInt4)) == null)) {
                        putInt4.commit();
                    }
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 149228377:
                if (str3.equals("allmakeData")) {
                    R(strArr);
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 536375440:
                if (str3.equals("allunread")) {
                    fnR();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 769522478:
                if (str3.equals("commentClear")) {
                    fnO();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 856773767:
                if (str3.equals("cleandb")) {
                    fnQ();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 1233668806:
                if (str3.equals("videoCacheClear")) {
                    fnP();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 1368796312:
                if (str3.equals("createFile")) {
                    l lVar4 = l.FmK;
                    l.fou();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 1550482439:
                if (str3.equals("delfile")) {
                    l lVar5 = l.FmK;
                    s.deleteDir(l.fos());
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            case 2103071987:
                if (str3.equals("commentDump")) {
                    fnN();
                    AppMethodBeat.o(118654);
                    return true;
                }
                AppMethodBeat.o(118654);
                return false;
            default:
                AppMethodBeat.o(118654);
                return false;
        }
    }

    private static void fnN() {
        AppMethodBeat.i(118655);
        j.b bVar = j.Fmy;
        for (T t : j.b.fof().frv()) {
            Log.i("MicroMsg.StoryCommand", "commentDump " + ((c) t).field_storyId + ' ' + ((c) t).field_readCommentId + ' ' + ((c) t).field_syncCommentId);
        }
        AppMethodBeat.o(118655);
    }

    private static void fnO() {
        AppMethodBeat.i(118656);
        j.b bVar = j.Fmy;
        Iterator<T> it = j.b.fof().frv().iterator();
        while (it.hasNext()) {
            j.b bVar2 = j.Fmy;
            j.b.fof().delete(it.next(), new String[0]);
        }
        AppMethodBeat.o(118656);
    }

    private static void fnP() {
        AppMethodBeat.i(118657);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.o fog = j.b.fog();
        ArrayList<n> arrayList = new ArrayList();
        Cursor rawQuery = fog.db.rawQuery("select * from StoryVideoCacheInfo", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                n nVar = new n();
                nVar.convertFrom(rawQuery);
                arrayList.add(nVar);
            }
            rawQuery.close();
        }
        for (n nVar2 : arrayList) {
            j.b bVar2 = j.Fmy;
            j.b.fog().delete(nVar2, new String[0]);
        }
        AppMethodBeat.o(118657);
    }

    public static void fnQ() {
        AppMethodBeat.i(118658);
        Log.i("MicroMsg.StoryCommand", "cleanDb");
        j.b bVar = j.Fmy;
        j.b.fog().eIQ();
        j.b bVar2 = j.Fmy;
        j.b.fod().eIQ();
        j.b bVar3 = j.Fmy;
        j.b.foe().eIQ();
        j.b bVar4 = j.Fmy;
        j.b.foc().eIQ();
        j.b bVar5 = j.Fmy;
        s.deleteDir(j.b.getAccStoryCachePath());
        com.tencent.mm.kernel.b.a ah = g.ah(PluginVideoEditor.class);
        p.g(ah, "MMKernel.plugin(PluginVideoEditor::class.java)");
        ((PluginVideoEditor) ah).getVideoEditorDataStorage().eIQ();
        AppMethodBeat.o(118658);
    }

    public static void fnR() {
        AppMethodBeat.i(118659);
        j.b bVar = j.Fmy;
        j.b.foc().eIQ();
        j.b bVar2 = j.Fmy;
        j.b.fog().eIQ();
        j.b bVar3 = j.Fmy;
        s.deleteDir(j.b.getAccStoryCachePath());
        j.b bVar4 = j.Fmy;
        for (T t : j.b.fod().frC()) {
            ((f) t).field_readId = 0;
            ((f) t).field_md5 = "";
            ((f) t).field_preLoadResource = 0;
            t.aSs("");
            ((f) t).field_preloadStoryId = 0;
            j.b bVar5 = j.Fmy;
            j.b.fod().b(((f) t).systemRowid, t);
        }
        Log.i("MicroMsg.StoryCommand", "allUnRead done");
        u.makeText(MMApplicationContext.getContext(), "allUnRead Done", 1).show();
        AppMethodBeat.o(118659);
    }

    private static void Q(String[] strArr) {
        AppMethodBeat.i(118660);
        String str = strArr[2];
        j.b bVar = j.Fmy;
        f aRS = j.b.fod().aRS("foreverzeus");
        j.b bVar2 = j.Fmy;
        k foc = j.b.foc();
        j.b bVar3 = j.Fmy;
        boolean isEqual = Util.isEqual(j.b.fau(), "foreverzeus");
        int aWB = cl.aWB();
        i.a aVar = i.Fmb;
        List a2 = k.a(foc, "foreverzeus", isEqual, aWB - i.FlY);
        if (a2.isEmpty()) {
            u.makeText(MMApplicationContext.getContext(), "allmockData error1", 1).show();
            AppMethodBeat.o(118660);
            return;
        }
        List<String> Ic = v.Ic(str);
        if (Ic != null) {
            for (T t : Ic) {
                j.b bVar4 = j.Fmy;
                com.tencent.mm.plugin.story.i.g fod = j.b.fod();
                p.g(t, LocaleUtil.ITALIAN);
                f aRS2 = fod.aRS(t);
                int i2 = (int) aRS2.systemRowid;
                if (!aRS2.isValid()) {
                    aRS.setUserName(t);
                    aRS.field_storyPostTime = (int) Util.currentTicks();
                    aRS.systemRowid = -1;
                    if (i2 < 0) {
                        j.b bVar5 = j.Fmy;
                        j.b.fod().insert(aRS);
                    } else {
                        j.b bVar6 = j.Fmy;
                        j.b.fod().b(((long) i2) * 1, aRS);
                    }
                }
                com.tencent.mm.plugin.story.i.j jVar = (com.tencent.mm.plugin.story.i.j) a2.get(0);
                jVar.field_userName = t;
                jVar.field_createTime = cl.aWB();
                eek frG = jVar.frG();
                frG.UserName = t;
                jVar.b(frG);
                jVar.ecf = -1;
                j.b bVar7 = j.Fmy;
                j.b.foc().insert(jVar);
            }
        }
        u.makeText(MMApplicationContext.getContext(), "allmockData done", 1).show();
        AppMethodBeat.o(118660);
    }

    private static void R(String[] strArr) {
        AppMethodBeat.i(118661);
        int safeParseInt = Util.safeParseInt(strArr[2]);
        Log.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(safeParseInt)));
        j.b bVar = j.Fmy;
        k foc = j.b.foc();
        j.b bVar2 = j.Fmy;
        boolean isEqual = Util.isEqual(j.b.fau(), "ychengo");
        int aWB = cl.aWB();
        i.a aVar = i.Fmb;
        List a2 = k.a(foc, "ychengo", isEqual, aWB - i.FlY);
        for (int i2 = 0; i2 < safeParseInt; i2++) {
            com.tencent.mm.plugin.story.i.j jVar = (com.tencent.mm.plugin.story.i.j) a2.get(0);
            jVar.field_userName = "ychengo";
            jVar.field_createTime = cl.aWB();
            eek frG = jVar.frG();
            frG.UserName = "ychengo";
            jVar.b(frG);
            jVar.ecf = -1;
            j.b bVar3 = j.Fmy;
            j.b.foc().insert(jVar);
        }
        u.makeText(MMApplicationContext.getContext(), "testMakeData done ".concat(String.valueOf(safeParseInt)), 1).show();
        AppMethodBeat.o(118661);
    }

    public static void fnS() {
        AppMethodBeat.i(118662);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
        AppMethodBeat.o(118662);
    }
}
