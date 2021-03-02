package org.xwalk.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class XWalkFileChooser {
    private static final String ALL_AUDIO_TYPES = "audio/*";
    private static final String ALL_IMAGE_TYPES = "image/*";
    private static final String ALL_VIDEO_TYPES = "video/*";
    private static final String ANY_TYPES = "*/*";
    private static final String AUDIO_TYPE = "audio/";
    private static final String IMAGE_TYPE = "image/";
    public static final int INPUT_FILE_REQUEST_CODE = 1;
    private static final String PATH_PREFIX = "file:";
    private static final String SPLIT_EXPRESSION = ",";
    private static final String TAG = "XWalkFileChooser";
    private static final String VIDEO_TYPE = "video/";
    private static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private Activity mActivity;
    private String mCameraPhotoPath;
    private ValueCallback<Uri> mFilePathCallback;

    public XWalkFileChooser(Activity activity) {
        this.mActivity = activity;
    }

    public boolean showFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(154729);
        this.mFilePathCallback = valueCallback;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
            File createImageFile = createImageFile();
            if (createImageFile != null) {
                this.mCameraPhotoPath = PATH_PREFIX + createImageFile.getAbsolutePath();
                intent.putExtra("PhotoPath", this.mCameraPhotoPath);
                intent.putExtra("output", Uri.fromFile(createImageFile));
            } else {
                intent = null;
            }
        }
        Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
        Intent intent3 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        Intent intent4 = new Intent("android.intent.action.GET_CONTENT");
        intent4.addCategory("android.intent.category.OPENABLE");
        ArrayList arrayList = new ArrayList();
        if (!str.contains(SPLIT_EXPRESSION) && !str.contains(ANY_TYPES)) {
            if (str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                if (!str.startsWith(IMAGE_TYPE)) {
                    if (str.startsWith("video/")) {
                        this.mActivity.startActivityForResult(intent2, 1);
                        Log.d(TAG, "Started camcorder");
                        AppMethodBeat.o(154729);
                    } else if (str.startsWith("audio/")) {
                        this.mActivity.startActivityForResult(intent3, 1);
                        Log.d(TAG, "Started sound recorder");
                        AppMethodBeat.o(154729);
                    }
                    return true;
                } else if (intent != null) {
                    this.mActivity.startActivityForResult(intent, 1);
                    Log.d(TAG, "Started taking picture");
                    AppMethodBeat.o(154729);
                    return true;
                }
            } else if (str.startsWith(IMAGE_TYPE)) {
                if (intent != null) {
                    arrayList.add(intent);
                }
                intent4.setType(ALL_IMAGE_TYPES);
            } else if (str.startsWith("video/")) {
                arrayList.add(intent2);
                intent4.setType(ALL_VIDEO_TYPES);
            } else if (str.startsWith("audio/")) {
                arrayList.add(intent3);
                intent4.setType(ALL_AUDIO_TYPES);
            }
        }
        if (arrayList.isEmpty() && canWriteExternalStorage()) {
            if (intent != null) {
                arrayList.add(intent);
            }
            arrayList.add(intent2);
            arrayList.add(intent3);
            intent4.setType(ANY_TYPES);
        }
        Intent intent5 = new Intent("android.intent.action.CHOOSER");
        intent5.putExtra("android.intent.extra.INTENT", intent4);
        if (!arrayList.isEmpty()) {
            intent5.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
        }
        this.mActivity.startActivityForResult(intent5, 1);
        Log.d(TAG, "Started chooser");
        AppMethodBeat.o(154729);
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri uri;
        AppMethodBeat.i(154730);
        if (i2 == 1 && this.mFilePathCallback != null) {
            Log.d(TAG, "Activity result: ".concat(String.valueOf(i3)));
            if (-1 != i3) {
                if (i3 == 0) {
                    deleteImageFile();
                }
                uri = null;
            } else if (intent == null || (intent.getAction() == null && intent.getData() == null)) {
                if (this.mCameraPhotoPath != null) {
                    uri = Uri.parse(this.mCameraPhotoPath);
                }
                uri = null;
            } else {
                String dataString = intent.getDataString();
                if (dataString != null) {
                    uri = Uri.parse(dataString);
                } else {
                    uri = null;
                }
                deleteImageFile();
            }
            if (uri != null) {
                Log.d(TAG, "Received file: " + uri.toString());
            }
            this.mFilePathCallback.onReceiveValue(uri);
            this.mFilePathCallback = null;
        }
        AppMethodBeat.o(154730);
    }

    private boolean canWriteExternalStorage() {
        AppMethodBeat.i(154731);
        try {
            boolean contains = Arrays.asList(this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 4096).requestedPermissions).contains(WRITE_EXTERNAL_STORAGE);
            AppMethodBeat.o(154731);
            return contains;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            AppMethodBeat.o(154731);
            return false;
        }
    }

    private File createImageFile() {
        AppMethodBeat.i(154732);
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Log.e(TAG, "External storage is not mounted.");
            AppMethodBeat.o(154732);
            return null;
        }
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        try {
            File createTempFile = File.createTempFile(str, ".jpg", externalStoragePublicDirectory);
            Log.d(TAG, "Created image file: " + createTempFile.getAbsolutePath());
            AppMethodBeat.o(154732);
            return createTempFile;
        } catch (IOException e2) {
            Log.e(TAG, "Unable to create Image File, please make sure permission 'WRITE_EXTERNAL_STORAGE' was added.");
            AppMethodBeat.o(154732);
            return null;
        }
    }

    private boolean deleteImageFile() {
        AppMethodBeat.i(154733);
        if (this.mCameraPhotoPath == null || !this.mCameraPhotoPath.contains(PATH_PREFIX)) {
            AppMethodBeat.o(154733);
            return false;
        }
        String str = this.mCameraPhotoPath.split(PATH_PREFIX)[1];
        boolean delete = new File(str).delete();
        Log.d(TAG, "Delete image file: " + str + " result: " + delete);
        AppMethodBeat.o(154733);
        return delete;
    }
}
