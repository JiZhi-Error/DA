package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI extends HellActivity {
    private int het;
    private boolean mInit = false;
    private int xos;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(111501);
        Log.i("MicroMsg.GalleryEntryUI", "on create");
        super.onCreate(bundle);
        Log.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this));
        this.het = getIntent().getIntExtra("query_source_type", 3);
        this.xos = getIntent().getIntExtra("query_media_type", 1);
        Log.i("MicroMsg.GalleryEntryUI", "query souce: " + this.het + ", queryType: " + this.xos);
        e.dQK().setQueryType(this.xos);
        e.dQK().mcq = this.het;
        AppMethodBeat.o(111501);
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(111502);
        Log.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        this.mInit = true;
        AppMethodBeat.o(111502);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onResume() {
        AppMethodBeat.i(111503);
        Log.i("MicroMsg.GalleryEntryUI", "on resume, init %B", Boolean.valueOf(this.mInit));
        super.onResume();
        if (!this.mInit) {
            Log.i("MicroMsg.GalleryEntryUI", "doRedirect %s", Util.getStack());
            Intent intent = getIntent();
            if (intent.getBooleanExtra("preview_image", false)) {
                Log.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                Intent intent2 = new Intent(this, ImagePreviewUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("max_select_count", intent.getIntExtra("max_select_count", 9));
                intent2.putExtra("query_source_type", this.het);
                intent2.putExtra("isPreviewPhoto", intent.getBooleanExtra("isPreviewPhoto", false));
                intent2.putExtra("preview_image", intent.getBooleanExtra("preview_image", false));
                intent2.putExtra("key_force_hide_edit_image_button", getIntent().getBooleanExtra("key_force_hide_edit_image_button", false));
                intent2.putExtra("key_force_show_raw_image_button", getIntent().getBooleanExtra("key_force_show_raw_image_button", false));
                intent2.putExtra("key_is_raw_image_button_disable", getIntent().getBooleanExtra("key_is_raw_image_button_disable", false));
                String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
                String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
                if (!Util.isNullOrNil(stringExtra)) {
                    intent2.putExtra("GalleryUI_FromUser", stringExtra);
                }
                if (!Util.isNullOrNil(stringExtra2)) {
                    intent2.putExtra("GalleryUI_ToUser", stringExtra2);
                }
                intent2.putStringArrayListExtra("preview_image_list", stringArrayListExtra);
                startActivityForResult(intent2, 1);
            } else {
                intent.setClass(this, AlbumPreviewUI.class);
                if (intent.getBooleanExtra("need_to_clear_top", true)) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("key_edit_text_color", getIntent().getStringExtra("key_edit_text_color"));
                intent.putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
                intent.putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
                intent.putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
                intent.putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
                intent.putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
                intent.putExtra("key_force_hide_edit_image_button", getIntent().getBooleanExtra("key_force_hide_edit_image_button", false));
                intent.putExtra("key_force_show_raw_image_button", getIntent().getBooleanExtra("key_force_show_raw_image_button", false));
                intent.putExtra("key_is_raw_image_button_disable", getIntent().getBooleanExtra("key_is_raw_image_button_disable", false));
                intent.putExtra("GalleryUI_SkipVideoSizeLimit", getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false));
                intent.putExtra("album_business_tag", getIntent().getStringExtra("album_business_tag"));
                intent.putExtra("album_video_max_duration", getIntent().getIntExtra("album_video_max_duration", 10));
                intent.putExtra("album_video_min_duration", getIntent().getIntExtra("album_video_min_duration", 0));
                startActivityForResult(intent, 0);
            }
            this.mInit = true;
        }
        AppMethodBeat.o(111503);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(111504);
        super.onNewIntent(intent);
        Log.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", Integer.valueOf(hashCode()));
        AppMethodBeat.o(111504);
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(111505);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = intent == null ? "" : intent.toString();
        Log.i("MicroMsg.GalleryEntryUI", "on activity result, requestCode %d resultCode %d, data:%s", objArr);
        switch (i3) {
            case -1:
                if (intent != null) {
                    setResult(-1, intent);
                    break;
                } else {
                    AppMethodBeat.o(111505);
                    return;
                }
            case 0:
                Log.d("MicroMsg.GalleryEntryUI", "user choose canceld");
                setResult(0);
                break;
            case 1:
                setResult(1);
                break;
        }
        finish();
        AppMethodBeat.o(111505);
    }
}
