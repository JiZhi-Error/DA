package com.tencent.mm.plugin.music.model.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class a {

    public static final class j implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private j() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(63085);
            IPCBoolean euI = euI();
            AppMethodBeat.o(63085);
            return euI;
        }

        private static IPCBoolean euI() {
            AppMethodBeat.i(63084);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc showAudioToast");
                IPCBoolean iPCBoolean = new IPCBoolean(((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.o(63084);
                return iPCBoolean;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc showAudioToast task", new Object[0]);
                IPCBoolean iPCBoolean2 = new IPCBoolean(false);
                AppMethodBeat.o(63084);
                return iPCBoolean2;
            }
        }
    }

    public static final class f implements com.tencent.mm.ipcinvoker.k<IPCInteger, IPCInteger> {
        private f() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCInteger invoke(IPCInteger iPCInteger) {
            AppMethodBeat.i(63077);
            IPCInteger a2 = a(iPCInteger);
            AppMethodBeat.o(63077);
            return a2;
        }

        private static IPCInteger a(IPCInteger iPCInteger) {
            AppMethodBeat.i(63076);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
                IPCInteger iPCInteger2 = new IPCInteger(((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(iPCInteger.value))).intValue());
                AppMethodBeat.o(63076);
                return iPCInteger2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
                IPCInteger iPCInteger3 = new IPCInteger(iPCInteger.value);
                AppMethodBeat.o(63076);
                return iPCInteger3;
            }
        }
    }

    public static final class b implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCString> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(63069);
            IPCString bOT = bOT();
            AppMethodBeat.o(63069);
            return bOT;
        }

        private static IPCString bOT() {
            AppMethodBeat.i(63068);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
                IPCString iPCString = new IPCString(com.tencent.mm.kernel.g.aAh().hqG);
                AppMethodBeat.o(63068);
                return iPCString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc getAccPath task", new Object[0]);
                IPCString iPCString2 = new IPCString("");
                AppMethodBeat.o(63068);
                return iPCString2;
            }
        }
    }

    public static final class c implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCLong> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCLong invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(63071);
            IPCLong euH = euH();
            AppMethodBeat.o(63071);
            return euH;
        }

        private static IPCLong euH() {
            AppMethodBeat.i(63070);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getLastScanMusicPieceFileTime task");
                IPCLong iPCLong = new IPCLong(((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, (Object) 0L)).longValue());
                AppMethodBeat.o(63070);
                return iPCLong;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc getLastScanMusicPieceFileTime task", new Object[0]);
                IPCLong iPCLong2 = new IPCLong(0);
                AppMethodBeat.o(63070);
                return iPCLong2;
            }
        }
    }

    public static final class h implements com.tencent.mm.ipcinvoker.k<IPCLong, IPCVoid> {
        private h() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(IPCLong iPCLong) {
            AppMethodBeat.i(63081);
            IPCVoid a2 = a(iPCLong);
            AppMethodBeat.o(63081);
            return a2;
        }

        private static IPCVoid a(IPCLong iPCLong) {
            AppMethodBeat.i(63080);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setLastScanMusicPieceFileTime task");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(iPCLong.value));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc setLastScanMusicPieceFileTime task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(63080);
            return iPCVoid;
        }
    }

    public static final class l implements com.tencent.mm.ipcinvoker.k<IPCString, IPCString> {
        private l() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            AppMethodBeat.i(63089);
            IPCString d2 = d(iPCString);
            AppMethodBeat.o(63089);
            return d2;
        }

        private static IPCString d(IPCString iPCString) {
            com.tencent.mm.plugin.music.model.e.c aHX;
            String str;
            boolean z = true;
            AppMethodBeat.i(63088);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updatePieceMusicInfo Task, src:%s", iPCString);
                String str2 = iPCString.value;
                com.tencent.mm.plugin.music.model.e.d euE = o.euE();
                if (TextUtils.isEmpty(str2)) {
                    Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
                    aHX = null;
                } else {
                    String aId = com.tencent.mm.plugin.music.h.b.aId(str2);
                    aHX = euE.aHX(aId);
                    if (aHX == null) {
                        aHX = new com.tencent.mm.plugin.music.model.e.c();
                        z = false;
                    }
                    aHX.field_musicId = aId;
                    aHX.field_musicUrl = str2;
                    aHX.field_fileName = com.tencent.mm.plugin.music.h.b.aIe(str2);
                    Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", aId, aHX.field_fileName);
                    if (z) {
                        Log.i("MicroMsg.Music.PieceMusicInfoStorage", "update PieceMusicInfo");
                        euE.update(aHX, new String[0]);
                    } else {
                        Log.i("MicroMsg.Music.PieceMusicInfoStorage", "insert PieceMusicInfo");
                        euE.insert(aHX);
                    }
                    euE.AlG.put(aId, aHX);
                }
                if (aHX != null) {
                    str = aHX.field_musicId;
                } else {
                    str = null;
                }
                IPCString iPCString2 = new IPCString(str);
                AppMethodBeat.o(63088);
                return iPCString2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc updatePieceMusicInfo task", new Object[0]);
                IPCString iPCString3 = new IPCString("");
                AppMethodBeat.o(63088);
                return iPCString3;
            }
        }
    }

    public static final class e implements com.tencent.mm.ipcinvoker.k<IPCString, IPCAudioParamResponse> {
        private e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCAudioParamResponse invoke(IPCString iPCString) {
            AppMethodBeat.i(63075);
            IPCAudioParamResponse e2 = e(iPCString);
            AppMethodBeat.o(63075);
            return e2;
        }

        private static IPCAudioParamResponse e(IPCString iPCString) {
            com.tencent.mm.ay.j jVar;
            AppMethodBeat.i(63074);
            try {
                Log.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getPieceMusicInfo Task, src:%s", iPCString);
                com.tencent.mm.plugin.music.model.e.c aHX = o.euE().aHX(iPCString.value);
                if (aHX == null) {
                    Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "initData pMusic is null!'");
                    jVar = null;
                } else {
                    com.tencent.mm.ay.j jVar2 = new com.tencent.mm.ay.j();
                    jVar2.dSF = aHX.field_musicId;
                    jVar2.musicUrl = aHX.field_musicUrl;
                    jVar2.fileName = aHX.field_fileName;
                    jVar2.jfB = aHX.field_fileCacheComplete;
                    jVar2.jfC = aHX.field_pieceFileMIMEType;
                    jVar2.jfA = aHX.field_indexBitData;
                    jVar2.jfD = aHX.field_removeDirtyBit;
                    jVar = jVar2;
                }
                if (jVar != null) {
                    IPCAudioParamResponse iPCAudioParamResponse = new IPCAudioParamResponse(jVar);
                    AppMethodBeat.o(63074);
                    return iPCAudioParamResponse;
                }
                Log.e("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "pmInfo is null");
                IPCAudioParamResponse iPCAudioParamResponse2 = new IPCAudioParamResponse();
                AppMethodBeat.o(63074);
                return iPCAudioParamResponse2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc getPieceMusicInfo task", new Object[0]);
            }
        }
    }

    public static final class k implements com.tencent.mm.ipcinvoker.k<IPCAudioParamRequest, IPCVoid> {
        private k() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(63087);
            IPCVoid a2 = a(iPCAudioParamRequest);
            AppMethodBeat.o(63087);
            return a2;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            boolean z = true;
            AppMethodBeat.i(63086);
            try {
                Object[] objArr = new Object[2];
                objArr[0] = iPCAudioParamRequest.dSF;
                if (iPCAudioParamRequest.jfA == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileIndexBitCache Task, musicId:%s, bitset is valid:%b", objArr);
                String str = iPCAudioParamRequest.dSF;
                byte[] bArr = iPCAudioParamRequest.jfA;
                com.tencent.mm.plugin.music.model.e.d euE = o.euE();
                ContentValues contentValues = new ContentValues();
                contentValues.put("indexBitData", bArr);
                int update = euE.db.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
                if (update <= 0) {
                    Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", Integer.valueOf(update), str);
                }
                com.tencent.mm.plugin.music.model.e.c cVar = euE.AlG.get(str);
                if (cVar != null) {
                    cVar.field_indexBitData = bArr;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc updateMusicFileIndexBitCache task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(63086);
            return iPCVoid;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.model.a.a.a$a  reason: collision with other inner class name */
    public static final class C1536a implements com.tencent.mm.ipcinvoker.k<IPCString, IPCVoid> {
        private C1536a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(IPCString iPCString) {
            AppMethodBeat.i(63067);
            IPCVoid c2 = c(iPCString);
            AppMethodBeat.o(63067);
            return c2;
        }

        private static IPCVoid c(IPCString iPCString) {
            AppMethodBeat.i(63066);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc deletePieceMusicInfo Task, musicId:%s", iPCString);
                String str = iPCString.value;
                com.tencent.mm.plugin.music.model.e.d euE = o.euE();
                Log.i("MicroMsg.Music.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", Integer.valueOf(euE.db.delete("PieceMusicInfo", "musicId=?", new String[]{str})), str);
                euE.AlG.remove(str);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc deletePieceMusicInfo task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(63066);
            return iPCVoid;
        }
    }

    public static final class m implements com.tencent.mm.ipcinvoker.k<IPCAudioParamRequest, IPCVoid> {
        private m() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(63091);
            IPCVoid a2 = a(iPCAudioParamRequest);
            AppMethodBeat.o(63091);
            return a2;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(63090);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc updateMusicFileCacheComplete Task, musicId:%s, complete:%d", iPCAudioParamRequest.dSF, Integer.valueOf(iPCAudioParamRequest.AiS));
                String str = iPCAudioParamRequest.dSF;
                int i2 = iPCAudioParamRequest.AiS;
                com.tencent.mm.plugin.music.model.e.d euE = o.euE();
                ContentValues contentValues = new ContentValues();
                contentValues.put("fileCacheComplete", Integer.valueOf(i2));
                if (i2 == 1) {
                    contentValues.put("removeDirtyBit", (Integer) 1);
                }
                Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", Integer.valueOf(euE.db.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str})), str, Integer.valueOf(i2));
                com.tencent.mm.plugin.music.model.e.c cVar = euE.AlG.get(str);
                if (cVar != null) {
                    cVar.field_fileCacheComplete = i2;
                    if (i2 == 1) {
                        cVar.field_removeDirtyBit = 1;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc updateMusicFileCacheComplete task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(63090);
            return iPCVoid;
        }
    }

    public static final class i implements com.tencent.mm.ipcinvoker.k<IPCAudioParamRequest, IPCVoid> {
        private i() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(63083);
            IPCVoid a2 = a(iPCAudioParamRequest);
            AppMethodBeat.o(63083);
            return a2;
        }

        private static IPCVoid a(IPCAudioParamRequest iPCAudioParamRequest) {
            AppMethodBeat.i(63082);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc setMusicMIMETypeByMusicId Task, musicId:%s, mimeType:%s", iPCAudioParamRequest.dSF, iPCAudioParamRequest.mimeType);
                String str = iPCAudioParamRequest.dSF;
                String str2 = iPCAudioParamRequest.mimeType;
                com.tencent.mm.plugin.music.model.e.c aHX = o.euE().aHX(str);
                if (aHX == null) {
                    Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "setMusicMIMETypeByMusicId pMusic is null!'");
                } else if (TextUtils.isEmpty(aHX.field_pieceFileMIMEType) || !aHX.field_pieceFileMIMEType.equals(str2)) {
                    Log.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "updatePieceFileMIMEType()");
                    com.tencent.mm.plugin.music.model.e.d euE = o.euE();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("pieceFileMIMEType", str2);
                    Log.i("MicroMsg.Music.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", Integer.valueOf(euE.db.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str})), str);
                    com.tencent.mm.plugin.music.model.e.c cVar = euE.AlG.get(str);
                    if (cVar != null) {
                        cVar.field_pieceFileMIMEType = str2;
                    }
                } else {
                    Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "don't need update the piece file mime type");
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc setMusicMIMETypeByMusicId task", new Object[0]);
            }
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(63082);
            return iPCVoid;
        }
    }

    public static final class d implements com.tencent.mm.ipcinvoker.k<IPCString, IPCString> {
        private d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            AppMethodBeat.i(63073);
            IPCString d2 = d(iPCString);
            AppMethodBeat.o(63073);
            return d2;
        }

        private static IPCString d(IPCString iPCString) {
            String str;
            AppMethodBeat.i(63072);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getMusicMIMETypeByMusicId Task, musicId:%s", iPCString);
                com.tencent.mm.plugin.music.model.e.c aHX = o.euE().aHX(iPCString.value);
                if (aHX == null) {
                    Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "getMusicMIMETypeByMusicId pMusic is null!'");
                    str = null;
                } else {
                    Log.i("MicroMsg.Music.MusicDataSourceMainProcessImp", "music field_pieceFileMIMEType:%s", aHX.field_pieceFileMIMEType);
                    if (TextUtils.isEmpty(aHX.field_pieceFileMIMEType)) {
                        Log.e("MicroMsg.Music.MusicDataSourceMainProcessImp", "field_pieceFileMIMEType is null!'");
                        str = null;
                    } else {
                        str = aHX.field_pieceFileMIMEType;
                    }
                }
                IPCString iPCString2 = new IPCString(str);
                AppMethodBeat.o(63072);
                return iPCString2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc getMusicMIMETypeByMusicId task", new Object[0]);
                IPCString iPCString3 = new IPCString("");
                AppMethodBeat.o(63072);
                return iPCString3;
            }
        }
    }

    public static final class g implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private g() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(63079);
            IPCBoolean euI = euI();
            AppMethodBeat.o(63079);
            return euI;
        }

        private static IPCBoolean euI() {
            AppMethodBeat.i(63078);
            try {
                Log.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc isSupportMixAudioByCP task");
                IPCBoolean iPCBoolean = new IPCBoolean(((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_MUSIC_OPEN_MIX_AUDIO_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue());
                AppMethodBeat.o(63078);
                return iPCBoolean;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e2, "ipc isSupportMixAudioByCP task", new Object[0]);
                IPCBoolean iPCBoolean2 = new IPCBoolean(false);
                AppMethodBeat.o(63078);
                return iPCBoolean2;
            }
        }
    }
}
