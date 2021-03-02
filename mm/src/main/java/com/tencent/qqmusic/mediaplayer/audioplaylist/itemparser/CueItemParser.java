package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CueItemParser extends AudioPlayListItemParser {
    public static final String TAG = "CueItemParser";
    private LineNumberReader mReader;
    protected List<TrackInfo> mTrackInfoList = new LinkedList();

    public CueItemParser(String str) {
        AppMethodBeat.i(76607);
        this.mUri = str;
        AppMethodBeat.o(76607);
    }

    private long convertTimeStrToMs(String str) {
        AppMethodBeat.i(76608);
        String[] split = str.split(":");
        long parseLong = Long.parseLong(split[0]);
        long parseLong2 = Long.parseLong(split[1]);
        long parseLong3 = (Long.parseLong(split[2]) * 10) + (((parseLong * 60) + parseLong2) * 1000);
        AppMethodBeat.o(76608);
        return parseLong3;
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public Iterator<TrackInfo> iterator() {
        AppMethodBeat.i(76609);
        Iterator<TrackInfo> it = this.mTrackInfoList.iterator();
        AppMethodBeat.o(76609);
        return it;
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public boolean isParseSuccess() {
        AppMethodBeat.i(76610);
        if (!this.mTrackInfoList.isEmpty()) {
            AppMethodBeat.o(76610);
            return true;
        }
        AppMethodBeat.o(76610);
        return false;
    }

    private String guessCharsetEncoding(String str) {
        AppMethodBeat.i(76611);
        Logger.i(TAG, "CueItemParser.guessCharsetEncoding, filePath: ".concat(String.valueOf(str)));
        String guessCharsetEncoding = guessCharsetEncoding(new FileInputStream(str));
        AppMethodBeat.o(76611);
        return guessCharsetEncoding;
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public void parse() {
        TrackInfo trackInfo;
        boolean z;
        long j2;
        AppMethodBeat.i(76612);
        Logger.i(TAG, "CueItemParser.parse, uri: " + this.mUri);
        File file = new File(this.mUri);
        String str = null;
        String str2 = null;
        String str3 = null;
        boolean z2 = false;
        int i2 = 0;
        long j3 = 0;
        int i3 = 0;
        TrackInfo trackInfo2 = null;
        this.mTrackInfoList.clear();
        try {
            this.mReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), guessCharsetEncoding(this.mUri)));
            boolean z3 = false;
            int i4 = 0;
            while (true) {
                try {
                    String readLine = this.mReader.readLine();
                    i4 = this.mReader.getLineNumber();
                    if (!TextUtils.isEmpty(readLine)) {
                        if (!z2 && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                            str2 = delSeprator(readLine);
                        }
                        if (!z2 && readLine.trim().toUpperCase().startsWith(ShareConstants.TITLE)) {
                            str = delSeprator(readLine);
                        }
                        if (readLine.trim().toUpperCase().startsWith("FILE")) {
                            if (z2) {
                                z2 = false;
                            }
                            if (!(j3 == 0 || trackInfo2 == null)) {
                                trackInfo2.setEndPostion(j3);
                            }
                            String delSeprator = delSeprator(readLine);
                            String parent = file.getParent();
                            if (!parent.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                                parent = parent + FilePathGenerator.ANDROID_DIR_SEP;
                            }
                            if (delSeprator.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                                delSeprator = delSeprator.substring(1);
                            }
                            str3 = parent + delSeprator;
                            if (!new File(str3).exists()) {
                                IOException iOException = new IOException("media file in cue not exist! cue Path: " + this.mUri);
                                AppMethodBeat.o(76612);
                                throw iOException;
                            }
                            NativeDecoder nativeDecoder = new NativeDecoder();
                            int init = nativeDecoder.init(new FileDataSource(str3));
                            if (init == 0) {
                                j2 = nativeDecoder.getAudioInformation().getDuration();
                            } else {
                                Logger.e(TAG, "media item in cue init fail! ret = " + init + " ,path: " + str3);
                                j2 = j3;
                            }
                            nativeDecoder.release();
                            j3 = j2;
                        }
                        if (readLine.trim().toUpperCase().startsWith("TRACK")) {
                            trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                            trackInfo.setFilePath(str3);
                            z2 = true;
                            i2++;
                        } else {
                            trackInfo = trackInfo2;
                        }
                        if (z2 && readLine.trim().toUpperCase().startsWith(ShareConstants.TITLE)) {
                            trackInfo.setTitle(delSeprator(readLine));
                        }
                        if (z2 && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                            trackInfo.setPerformer(delSeprator(readLine));
                        }
                        if (i2 == 1 && readLine.trim().toUpperCase().startsWith("INDEX")) {
                            if (!readLine.trim().contains(" 01 ")) {
                                IOException iOException2 = new IOException("first item in CUE must only have feature \"INDEX 01\"!");
                                AppMethodBeat.o(76612);
                                throw iOException2;
                            }
                            trackInfo.setStartPosition(convertTimeStrToMs(readLine.trim().split(" 01 ")[1].trim()));
                        }
                        if (i2 < 2 || !readLine.trim().toUpperCase().startsWith("INDEX")) {
                            z = z3;
                        } else if (readLine.trim().contains(" 00 ")) {
                            this.mTrackInfoList.get(i2 - 2).setEndPostion(convertTimeStrToMs(readLine.trim().split(" 00 ")[1].trim()));
                            z = true;
                        } else if (readLine.trim().contains(" 01 ")) {
                            String trim = readLine.trim().split(" 01 ")[1].trim();
                            trackInfo.setStartPosition(convertTimeStrToMs(trim));
                            if (!z3) {
                                this.mTrackInfoList.get(i2 - 2).setEndPostion(convertTimeStrToMs(trim));
                            }
                            z = z3;
                        } else {
                            IOException iOException3 = new IOException("item " + i2 + " in CUE have illegel feature \"INDEX\"!");
                            AppMethodBeat.o(76612);
                            throw iOException3;
                        }
                        if (i2 > 0 && readLine.trim().toUpperCase().startsWith("INDEX") && readLine.trim().contains(" 01 ")) {
                            this.mTrackInfoList.add(trackInfo);
                            trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                            trackInfo.setFilePath(str3);
                            z = false;
                        }
                        z3 = z;
                        trackInfo2 = trackInfo;
                    } else {
                        if (!this.mTrackInfoList.isEmpty()) {
                            TrackInfo trackInfo3 = this.mTrackInfoList.get(this.mTrackInfoList.size() - 1);
                            if (!(j3 == 0 || trackInfo3.getRange() == null || ((Long) trackInfo3.getRange().second).longValue() != 0)) {
                                trackInfo3.setEndPostion(j3);
                            }
                            for (int i5 = 0; i5 < this.mTrackInfoList.size(); i5++) {
                                TrackInfo trackInfo4 = this.mTrackInfoList.get(i5);
                                if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(trackInfo4.getAlbum())) {
                                    trackInfo4.setAlbum(str);
                                }
                                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(trackInfo4.getPerformer())) {
                                    trackInfo4.setPerformer(str2);
                                }
                            }
                        }
                        try {
                            this.mReader.close();
                            AppMethodBeat.o(76612);
                            return;
                        } catch (Exception e2) {
                            Logger.e(TAG, "LineNumberReader close ex", e2);
                            AppMethodBeat.o(76612);
                            return;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    i3 = i4;
                    try {
                        ParseException parseException = new ParseException("Parse Exception occured", e, i3);
                        AppMethodBeat.o(76612);
                        throw parseException;
                    } catch (Throwable th) {
                        try {
                            this.mReader.close();
                        } catch (Exception e4) {
                            Logger.e(TAG, "LineNumberReader close ex", e4);
                        }
                        AppMethodBeat.o(76612);
                        throw th;
                    }
                }
            }
        } catch (IOException e5) {
            e = e5;
            ParseException parseException2 = new ParseException("Parse Exception occured", e, i3);
            AppMethodBeat.o(76612);
            throw parseException2;
        }
    }
}
