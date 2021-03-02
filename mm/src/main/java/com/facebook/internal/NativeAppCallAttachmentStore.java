package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class NativeAppCallAttachmentStore {
    static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    private static final String TAG = NativeAppCallAttachmentStore.class.getName();
    private static File attachmentsDirectory;

    static {
        AppMethodBeat.i(17872);
        AppMethodBeat.o(17872);
    }

    private NativeAppCallAttachmentStore() {
    }

    public static Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        AppMethodBeat.i(17860);
        Validate.notNull(uuid, "callId");
        Validate.notNull(bitmap, "attachmentBitmap");
        Attachment attachment = new Attachment(uuid, bitmap, null);
        AppMethodBeat.o(17860);
        return attachment;
    }

    public static Attachment createAttachment(UUID uuid, Uri uri) {
        AppMethodBeat.i(17861);
        Validate.notNull(uuid, "callId");
        Validate.notNull(uri, "attachmentUri");
        Attachment attachment = new Attachment(uuid, null, uri);
        AppMethodBeat.o(17861);
        return attachment;
    }

    private static void processAttachmentBitmap(Bitmap bitmap, File file) {
        AppMethodBeat.i(17862);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
            AppMethodBeat.o(17862);
        }
    }

    private static void processAttachmentFile(Uri uri, boolean z, File file) {
        InputStream openInputStream;
        AppMethodBeat.i(17863);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (!z) {
            try {
                openInputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                Utility.closeQuietly(fileOutputStream);
                AppMethodBeat.o(17863);
                throw th;
            }
        } else {
            openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
        }
        Utility.copyAndCloseInputStream(openInputStream, fileOutputStream);
        Utility.closeQuietly(fileOutputStream);
        AppMethodBeat.o(17863);
    }

    public static void addAttachments(Collection<Attachment> collection) {
        AppMethodBeat.i(17864);
        if (collection == null || collection.size() == 0) {
            AppMethodBeat.o(17864);
            return;
        }
        if (attachmentsDirectory == null) {
            cleanupAllAttachments();
        }
        ensureAttachmentsDirectoryExists();
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (Attachment attachment : collection) {
                if (attachment.shouldCreateFile) {
                    File attachmentFile = getAttachmentFile(attachment.callId, attachment.attachmentName, true);
                    arrayList.add(attachmentFile);
                    if (attachment.bitmap != null) {
                        processAttachmentBitmap(attachment.bitmap, attachmentFile);
                    } else if (attachment.originalUri != null) {
                        processAttachmentFile(attachment.originalUri, attachment.isContentUri, attachmentFile);
                    }
                }
            }
            AppMethodBeat.o(17864);
        } catch (IOException e2) {
            new StringBuilder("Got unexpected exception:").append(e2);
            for (File file : arrayList) {
                try {
                    file.delete();
                } catch (Exception e3) {
                }
            }
            FacebookException facebookException = new FacebookException(e2);
            AppMethodBeat.o(17864);
            throw facebookException;
        }
    }

    public static void cleanupAttachmentsForCall(UUID uuid) {
        AppMethodBeat.i(17865);
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            Utility.deleteDirectory(attachmentsDirectoryForCall);
        }
        AppMethodBeat.o(17865);
    }

    public static File openAttachment(UUID uuid, String str) {
        AppMethodBeat.i(17866);
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.o(17866);
            throw fileNotFoundException;
        }
        try {
            File attachmentFile = getAttachmentFile(uuid, str, false);
            AppMethodBeat.o(17866);
            return attachmentFile;
        } catch (IOException e2) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException();
            AppMethodBeat.o(17866);
            throw fileNotFoundException2;
        }
    }

    static synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            AppMethodBeat.i(17867);
            if (attachmentsDirectory == null) {
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
            AppMethodBeat.o(17867);
        }
        return file;
    }

    static File ensureAttachmentsDirectoryExists() {
        AppMethodBeat.i(17868);
        File attachmentsDirectory2 = getAttachmentsDirectory();
        attachmentsDirectory2.mkdirs();
        AppMethodBeat.o(17868);
        return attachmentsDirectory2;
    }

    static File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        AppMethodBeat.i(17869);
        if (attachmentsDirectory == null) {
            AppMethodBeat.o(17869);
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(17869);
        return file;
    }

    static File getAttachmentFile(UUID uuid, String str, boolean z) {
        AppMethodBeat.i(17870);
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            AppMethodBeat.o(17870);
            return null;
        }
        try {
            File file = new File(attachmentsDirectoryForCall, URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            AppMethodBeat.o(17870);
            return file;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(17870);
            return null;
        }
    }

    public static void cleanupAllAttachments() {
        AppMethodBeat.i(17871);
        Utility.deleteDirectory(getAttachmentsDirectory());
        AppMethodBeat.o(17871);
    }

    public static final class Attachment {
        private final String attachmentName;
        private final String attachmentUrl;
        private Bitmap bitmap;
        private final UUID callId;
        private boolean isContentUri;
        private Uri originalUri;
        private boolean shouldCreateFile;

        private Attachment(UUID uuid, Bitmap bitmap2, Uri uri) {
            String attachmentUrl2;
            boolean z = true;
            AppMethodBeat.i(17859);
            this.callId = uuid;
            this.bitmap = bitmap2;
            this.originalUri = uri;
            if (uri != null) {
                String scheme = uri.getScheme();
                if ("content".equalsIgnoreCase(scheme)) {
                    this.isContentUri = true;
                    this.shouldCreateFile = (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : z;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.shouldCreateFile = true;
                } else if (!Utility.isWebUri(uri)) {
                    FacebookException facebookException = new FacebookException("Unsupported scheme for media Uri : ".concat(String.valueOf(scheme)));
                    AppMethodBeat.o(17859);
                    throw facebookException;
                }
            } else if (bitmap2 != null) {
                this.shouldCreateFile = true;
            } else {
                FacebookException facebookException2 = new FacebookException("Cannot share media without a bitmap or Uri set");
                AppMethodBeat.o(17859);
                throw facebookException2;
            }
            this.attachmentName = !this.shouldCreateFile ? null : UUID.randomUUID().toString();
            if (!this.shouldCreateFile) {
                attachmentUrl2 = this.originalUri.toString();
            } else {
                attachmentUrl2 = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), uuid, this.attachmentName);
            }
            this.attachmentUrl = attachmentUrl2;
            AppMethodBeat.o(17859);
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }
    }
}
