package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
    private static final String INVALID_FILE_NAME = "..";
    private static final String TAG = FacebookContentProvider.class.getName();

    static {
        AppMethodBeat.i(17014);
        AppMethodBeat.o(17014);
    }

    public static String getAttachmentUrl(String str, UUID uuid, String str2) {
        AppMethodBeat.i(17011);
        String format = String.format("%s%s/%s/%s", ATTACHMENT_URL_BASE, str, uuid.toString(), str2);
        AppMethodBeat.o(17011);
        return format;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        AppMethodBeat.i(17012);
        Pair<UUID, String> parseCallIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        if (parseCallIdAndAttachmentName == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.o(17012);
            throw fileNotFoundException;
        }
        try {
            File openAttachment = NativeAppCallAttachmentStore.openAttachment((UUID) parseCallIdAndAttachmentName.first, (String) parseCallIdAndAttachmentName.second);
            if (openAttachment == null) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException();
                AppMethodBeat.o(17012);
                throw fileNotFoundException2;
            }
            ParcelFileDescriptor open = ParcelFileDescriptor.open(openAttachment, 268435456);
            AppMethodBeat.o(17012);
            return open;
        } catch (FileNotFoundException e2) {
            new StringBuilder("Got unexpected exception:").append(e2);
            AppMethodBeat.o(17012);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        AppMethodBeat.i(17013);
        try {
            String[] split = uri.getPath().substring(1).split(FilePathGenerator.ANDROID_DIR_SEP);
            String str = split[0];
            String str2 = split[1];
            if (INVALID_FILE_NAME.contentEquals(str) || INVALID_FILE_NAME.contentEquals(str2)) {
                Exception exc = new Exception();
                AppMethodBeat.o(17013);
                throw exc;
            }
            Pair<UUID, String> pair = new Pair<>(UUID.fromString(str), str2);
            AppMethodBeat.o(17013);
            return pair;
        } catch (Exception e2) {
            AppMethodBeat.o(17013);
            return null;
        }
    }
}
