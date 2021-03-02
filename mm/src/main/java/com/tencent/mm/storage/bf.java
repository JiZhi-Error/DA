package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public final class bf {
    private static final bf Opq = new bf();
    public String Opi;
    private int Opj = 2;
    public int Opk = 32;
    HashMap<String, String> Opl = new HashMap<>();
    public HashMap<String, ArrayList<String>> Opm = new HashMap<>();
    public HashMap<String, String> Opn = new HashMap<>();
    public HashMap<String, ArrayList<a>> Opo = new HashMap<>();
    public Comparator<a> Opp = new Comparator<a>() {
        /* class com.tencent.mm.storage.bf.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3 == null && aVar4 == null) {
                return 0;
            }
            if (aVar3 != null) {
                if (aVar4 == null) {
                    return 1;
                }
                if (aVar3.index == aVar4.index) {
                    return 0;
                }
                if (aVar3.index > aVar4.index) {
                    return 1;
                }
            }
            return -1;
        }
    };
    public boolean mInit = false;

    public class a {
        int index;
        public String md5;

        a(String str, int i2) {
            this.md5 = str;
            this.index = i2;
        }
    }

    static {
        AppMethodBeat.i(199819);
        AppMethodBeat.o(199819);
    }

    public static bf gCF() {
        return Opq;
    }

    public bf() {
        AppMethodBeat.i(104958);
        AppMethodBeat.o(104958);
    }

    public final void clear() {
        AppMethodBeat.i(104959);
        if (this.Opl != null) {
            this.Opl.clear();
        }
        if (this.Opm != null) {
            this.Opm.clear();
        }
        if (this.Opn != null) {
            this.Opn.clear();
        }
        if (this.Opo != null) {
            this.Opo.clear();
        }
        AppMethodBeat.o(104959);
    }

    public final void gCG() {
        AppMethodBeat.i(104960);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.storage.bf.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104956);
                long currentTimeMillis = System.currentTimeMillis();
                bf bfVar = bf.this;
                bfVar.clear();
                Cursor cursor = null;
                try {
                    Cursor all = ((d) g.ah(d.class)).getEmojiStorageMgr().OpX.getAll();
                    if (all != null && all.moveToFirst()) {
                        int count = all.getCount();
                        for (int i2 = 0; i2 < count; i2++) {
                            com.tencent.mm.storage.emotion.h hVar = new com.tencent.mm.storage.emotion.h();
                            hVar.convertFrom(all);
                            String str = hVar.field_desc;
                            if (!Util.isNullOrNil(str)) {
                                bfVar.Opn.put(str.toLowerCase(), hVar.field_groupID);
                                ArrayList<String> arrayList = bfVar.Opm.get(hVar.field_groupID);
                                if (arrayList == null) {
                                    arrayList = new ArrayList<>();
                                }
                                arrayList.add(hVar.field_desc);
                                bfVar.Opm.put(hVar.field_groupID, arrayList);
                            }
                            all.moveToNext();
                        }
                    }
                    if (all != null) {
                        all.close();
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.emoji.EmojiDescNewMgr", Util.stackTraceToString(e2));
                    if (0 != 0) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    AppMethodBeat.o(104956);
                    throw th;
                }
                String lowerCase = LocaleUtil.getApplicationLanguage().toLowerCase();
                bfVar.Opi = lowerCase;
                Iterator<EmojiGroupInfo> it = bj.gCJ().OpO.gEG().iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo next = it.next();
                    Iterator<com.tencent.mm.storage.emotion.d> it2 = bj.gCJ().OpP.blj(next.field_productID).iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.storage.emotion.d next2 = it2.next();
                        String str2 = next2.field_desc;
                        String str3 = next2.field_md5;
                        String str4 = next2.field_lang;
                        int i3 = next.field_idx;
                        if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str4)) {
                            String lowerCase2 = str2.toLowerCase();
                            if (bfVar.Opo.containsKey(lowerCase2)) {
                                ArrayList<a> arrayList2 = bfVar.Opo.get(lowerCase2);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList<>();
                                }
                                arrayList2.add(new a(str3, i3));
                            } else {
                                ArrayList<a> arrayList3 = new ArrayList<>();
                                arrayList3.add(new a(str3, i3));
                                bfVar.Opo.put(lowerCase2, arrayList3);
                            }
                            if (str4.equals(lowerCase)) {
                                bfVar.Opl.put(str3, lowerCase2);
                            } else if (str4.equals(BuildConfig.KINDA_DEFAULT) && !bfVar.Opl.containsKey(str3)) {
                                bfVar.Opl.put(str3, lowerCase2);
                            }
                        }
                    }
                }
                Log.i("MicroMsg.emoji.EmojiDescNewMgr", "tryInit: %s, %s", Integer.valueOf(bfVar.Opo.size()), Integer.valueOf(bfVar.Opl.size()));
                bf.this.mInit = true;
                Log.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString());
                AppMethodBeat.o(104956);
            }

            public final String toString() {
                AppMethodBeat.i(104957);
                String str = super.toString() + "|newinit";
                AppMethodBeat.o(104957);
                return str;
            }
        }, "MicroMsg.emoji.EmojiDescNewMgr|newinit");
        AppMethodBeat.o(104960);
    }

    public final boolean EV(String str) {
        AppMethodBeat.i(199818);
        if (!this.mInit) {
            gCG();
        }
        if (f.bnP(str) > this.Opk) {
            Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            AppMethodBeat.o(199818);
            return false;
        } else if (Util.isNullOrNil(str) || this.Opo == null) {
            AppMethodBeat.o(199818);
            return false;
        } else {
            ArrayList<a> arrayList = this.Opo.get(str.toLowerCase());
            if (arrayList == null || arrayList.size() <= 0) {
                AppMethodBeat.o(199818);
                return false;
            }
            AppMethodBeat.o(199818);
            return true;
        }
    }

    public final String amp(String str) {
        AppMethodBeat.i(104961);
        if (this.Opl == null || !this.Opl.containsKey(str)) {
            Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from db");
            String amp = ((d) g.ah(d.class)).getEmojiStorageMgr().OpP.amp(str);
            AppMethodBeat.o(104961);
            return amp;
        }
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "getCurLangDesc: from map");
        String str2 = this.Opl.get(str);
        AppMethodBeat.o(104961);
        return str2;
    }
}
