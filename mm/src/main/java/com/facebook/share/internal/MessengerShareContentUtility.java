package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerShareContentUtility {
    public static final String ATTACHMENT = "attachment";
    public static final String ATTACHMENT_ID = "attachment_id";
    public static final String ATTACHMENT_PAYLOAD = "payload";
    public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
    public static final String ATTACHMENT_TYPE = "type";
    public static final String BUTTONS = "buttons";
    public static final String BUTTON_TYPE = "type";
    public static final String BUTTON_URL_TYPE = "web_url";
    public static final String DEFAULT_ACTION = "default_action";
    public static final String ELEMENTS = "elements";
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    public static final String FALLBACK_URL = "fallback_url";
    public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
    public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
    public static final String IMAGE_RATIO_SQUARE = "square";
    public static final String IMAGE_URL = "image_url";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_VIDEO = "video";
    public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
    public static final String PREVIEW_DEFAULT = "DEFAULT";
    public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
    public static final String SHARABLE = "sharable";
    public static final String SHARE_BUTTON_HIDE = "hide";
    public static final String SUBTITLE = "subtitle";
    public static final String TEMPLATE_GENERIC_TYPE = "generic";
    public static final String TEMPLATE_MEDIA_TYPE = "media";
    public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String WEBVIEW_RATIO = "webview_height_ratio";
    public static final String WEBVIEW_RATIO_COMPACT = "compact";
    public static final String WEBVIEW_RATIO_FULL = "full";
    public static final String WEBVIEW_RATIO_TALL = "tall";
    public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";

    static {
        AppMethodBeat.i(8170);
        AppMethodBeat.o(8170);
    }

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.i(8148);
        addGenericTemplateElementForPreview(bundle, shareMessengerGenericTemplateContent.getGenericTemplateElement());
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeGenericTemplateContent(shareMessengerGenericTemplateContent));
        AppMethodBeat.o(8148);
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8149);
        addOpenGraphMusicTemplateContentForPreview(bundle, shareMessengerOpenGraphMusicTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeOpenGraphMusicTemplateContent(shareMessengerOpenGraphMusicTemplateContent));
        AppMethodBeat.o(8149);
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8150);
        addMediaTemplateContentForPreview(bundle, shareMessengerMediaTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeMediaTemplateContent(shareMessengerMediaTemplateContent));
        AppMethodBeat.o(8150);
    }

    private static void addGenericTemplateElementForPreview(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        AppMethodBeat.i(8151);
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getButton(), false);
        } else if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getDefaultAction(), true);
        }
        Utility.putUri(bundle, ShareConstants.IMAGE_URL, shareMessengerGenericTemplateElement.getImageUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, "DEFAULT");
        Utility.putNonEmptyString(bundle, ShareConstants.TITLE, shareMessengerGenericTemplateElement.getTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle());
        AppMethodBeat.o(8151);
    }

    private static void addOpenGraphMusicTemplateContentForPreview(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8152);
        addActionButton(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_OPEN_GRAPH);
        Utility.putUri(bundle, ShareConstants.OPEN_GRAPH_URL, shareMessengerOpenGraphMusicTemplateContent.getUrl());
        AppMethodBeat.o(8152);
    }

    private static void addMediaTemplateContentForPreview(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8153);
        addActionButton(bundle, shareMessengerMediaTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, "DEFAULT");
        Utility.putNonEmptyString(bundle, ShareConstants.ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId());
        if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
            Utility.putUri(bundle, getMediaUrlKey(shareMessengerMediaTemplateContent.getMediaUrl()), shareMessengerMediaTemplateContent.getMediaUrl());
        }
        Utility.putNonEmptyString(bundle, "type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        AppMethodBeat.o(8153);
    }

    private static void addActionButton(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        AppMethodBeat.i(8154);
        if (shareMessengerActionButton == null) {
            AppMethodBeat.o(8154);
            return;
        }
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            addURLActionButton(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
        AppMethodBeat.o(8154);
    }

    private static void addURLActionButton(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        String str;
        AppMethodBeat.i(8155);
        if (z) {
            str = Utility.getUriString(shareMessengerURLActionButton.getUrl());
        } else {
            str = shareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(shareMessengerURLActionButton.getUrl());
        }
        Utility.putNonEmptyString(bundle, ShareConstants.TARGET_DISPLAY, str);
        Utility.putUri(bundle, ShareConstants.ITEM_URL, shareMessengerURLActionButton.getUrl());
        AppMethodBeat.o(8155);
    }

    private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.i(8156);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, TEMPLATE_GENERIC_TYPE).put(SHARABLE, shareMessengerGenericTemplateContent.getIsSharable()).put(IMAGE_ASPECT_RATIO, getImageRatioString(shareMessengerGenericTemplateContent.getImageAspectRatio())).put(ELEMENTS, new JSONArray().put(serializeGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement())))));
        AppMethodBeat.o(8156);
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8157);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "open_graph").put(ELEMENTS, new JSONArray().put(serializeOpenGraphMusicTemplateElement(shareMessengerOpenGraphMusicTemplateContent)))));
        AppMethodBeat.o(8157);
        return put;
    }

    private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8158);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "media").put(ELEMENTS, new JSONArray().put(serializeMediaTemplateElement(shareMessengerMediaTemplateContent)))));
        AppMethodBeat.o(8158);
        return put;
    }

    private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        AppMethodBeat.i(8159);
        JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.getTitle()).put(SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle()).put(IMAGE_URL, Utility.getUriString(shareMessengerGenericTemplateElement.getImageUrl()));
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerGenericTemplateElement.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            put.put(DEFAULT_ACTION, serializeActionButton(shareMessengerGenericTemplateElement.getDefaultAction(), true));
        }
        AppMethodBeat.o(8159);
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.i(8160);
        JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
        if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        AppMethodBeat.o(8160);
        return put;
    }

    private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.i(8161);
        JSONObject put = new JSONObject().put(ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl())).put(MEDIA_TYPE, getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        if (shareMessengerMediaTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerMediaTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        AppMethodBeat.o(8161);
        return put;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        AppMethodBeat.i(8162);
        JSONObject serializeActionButton = serializeActionButton(shareMessengerActionButton, false);
        AppMethodBeat.o(8162);
        return serializeActionButton;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        AppMethodBeat.i(8163);
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            JSONObject serializeURLActionButton = serializeURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton, z);
            AppMethodBeat.o(8163);
            return serializeURLActionButton;
        }
        AppMethodBeat.o(8163);
        return null;
    }

    private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        String title;
        AppMethodBeat.i(8164);
        JSONObject put = new JSONObject().put("type", BUTTON_URL_TYPE);
        if (z) {
            title = null;
        } else {
            title = shareMessengerURLActionButton.getTitle();
        }
        JSONObject put2 = put.put("title", title).put("url", Utility.getUriString(shareMessengerURLActionButton.getUrl())).put(WEBVIEW_RATIO, getWebviewHeightRatioString(shareMessengerURLActionButton.getWebviewHeightRatio())).put(MESSENGER_EXTENSIONS, shareMessengerURLActionButton.getIsMessengerExtensionURL()).put(FALLBACK_URL, Utility.getUriString(shareMessengerURLActionButton.getFallbackUrl())).put(WEBVIEW_SHARE_BUTTON, getShouldHideShareButton(shareMessengerURLActionButton));
        AppMethodBeat.o(8164);
        return put2;
    }

    private static String getMediaUrlKey(Uri uri) {
        AppMethodBeat.i(8165);
        String host = uri.getHost();
        if (Utility.isNullOrEmpty(host) || !FACEBOOK_DOMAIN.matcher(host).matches()) {
            AppMethodBeat.o(8165);
            return ShareConstants.IMAGE_URL;
        }
        AppMethodBeat.o(8165);
        return ShareConstants.MEDIA_URI;
    }

    private static String getWebviewHeightRatioString(ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio) {
        AppMethodBeat.i(8166);
        if (webviewHeightRatio == null) {
            AppMethodBeat.o(8166);
            return "full";
        }
        switch (webviewHeightRatio) {
            case WebviewHeightRatioCompact:
                AppMethodBeat.o(8166);
                return WEBVIEW_RATIO_COMPACT;
            case WebviewHeightRatioTall:
                AppMethodBeat.o(8166);
                return WEBVIEW_RATIO_TALL;
            default:
                AppMethodBeat.o(8166);
                return "full";
        }
    }

    private static String getImageRatioString(ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio) {
        AppMethodBeat.i(8167);
        if (imageAspectRatio == null) {
            AppMethodBeat.o(8167);
            return IMAGE_RATIO_HORIZONTAL;
        }
        switch (imageAspectRatio) {
            case SQUARE:
                AppMethodBeat.o(8167);
                return IMAGE_RATIO_SQUARE;
            default:
                AppMethodBeat.o(8167);
                return IMAGE_RATIO_HORIZONTAL;
        }
    }

    private static String getMediaType(ShareMessengerMediaTemplateContent.MediaType mediaType) {
        AppMethodBeat.i(8168);
        if (mediaType == null) {
            AppMethodBeat.o(8168);
            return "image";
        }
        switch (mediaType) {
            case VIDEO:
                AppMethodBeat.o(8168);
                return "video";
            default:
                AppMethodBeat.o(8168);
                return "image";
        }
    }

    private static String getShouldHideShareButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        AppMethodBeat.i(8169);
        if (shareMessengerURLActionButton.getShouldHideWebviewShareButton()) {
            AppMethodBeat.o(8169);
            return SHARE_BUTTON_HIDE;
        }
        AppMethodBeat.o(8169);
        return null;
    }
}
