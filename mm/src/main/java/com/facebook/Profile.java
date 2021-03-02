package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        /* class com.facebook.Profile.AnonymousClass2 */

        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel parcel) {
            AppMethodBeat.i(17242);
            Profile profile = new Profile(parcel);
            AppMethodBeat.o(17242);
            return profile;
        }

        @Override // android.os.Parcelable.Creator
        public final Profile[] newArray(int i2) {
            return new Profile[i2];
        }
    };
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private static final String TAG = Profile.class.getSimpleName();
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    static {
        AppMethodBeat.i(17256);
        AppMethodBeat.o(17256);
    }

    public static Profile getCurrentProfile() {
        AppMethodBeat.i(17245);
        Profile currentProfile = ProfileManager.getInstance().getCurrentProfile();
        AppMethodBeat.o(17245);
        return currentProfile;
    }

    public static void setCurrentProfile(Profile profile) {
        AppMethodBeat.i(17246);
        ProfileManager.getInstance().setCurrentProfile(profile);
        AppMethodBeat.o(17246);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AppMethodBeat.i(17247);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            setCurrentProfile(null);
            AppMethodBeat.o(17247);
            return;
        }
        Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback() {
            /* class com.facebook.Profile.AnonymousClass1 */

            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public final void onSuccess(JSONObject jSONObject) {
                AppMethodBeat.i(17240);
                String optString = jSONObject.optString("id");
                if (optString == null) {
                    AppMethodBeat.o(17240);
                    return;
                }
                String optString2 = jSONObject.optString("link");
                Profile.setCurrentProfile(new Profile(optString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
                AppMethodBeat.o(17240);
            }

            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public final void onFailure(FacebookException facebookException) {
                AppMethodBeat.i(17241);
                String unused = Profile.TAG;
                new StringBuilder("Got unexpected exception: ").append(facebookException);
                AppMethodBeat.o(17241);
            }
        });
        AppMethodBeat.o(17247);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        AppMethodBeat.i(17248);
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        AppMethodBeat.o(17248);
    }

    public final Uri getProfilePictureUri(int i2, int i3) {
        AppMethodBeat.i(17249);
        Uri profilePictureUri = ImageRequest.getProfilePictureUri(this.id, i2, i3);
        AppMethodBeat.o(17249);
        return profilePictureUri;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(17250);
        if (this == obj) {
            AppMethodBeat.o(17250);
            return true;
        } else if (!(obj instanceof Profile)) {
            AppMethodBeat.o(17250);
            return false;
        } else {
            Profile profile = (Profile) obj;
            if (!this.id.equals(profile.id) || this.firstName != null) {
                if (!this.firstName.equals(profile.firstName) || this.middleName != null) {
                    if (!this.middleName.equals(profile.middleName) || this.lastName != null) {
                        if (!this.lastName.equals(profile.lastName) || this.name != null) {
                            if (!this.name.equals(profile.name) || this.linkUri != null) {
                                boolean equals = this.linkUri.equals(profile.linkUri);
                                AppMethodBeat.o(17250);
                                return equals;
                            } else if (profile.linkUri == null) {
                                AppMethodBeat.o(17250);
                                return true;
                            } else {
                                AppMethodBeat.o(17250);
                                return false;
                            }
                        } else if (profile.name == null) {
                            AppMethodBeat.o(17250);
                            return true;
                        } else {
                            AppMethodBeat.o(17250);
                            return false;
                        }
                    } else if (profile.lastName == null) {
                        AppMethodBeat.o(17250);
                        return true;
                    } else {
                        AppMethodBeat.o(17250);
                        return false;
                    }
                } else if (profile.middleName == null) {
                    AppMethodBeat.o(17250);
                    return true;
                } else {
                    AppMethodBeat.o(17250);
                    return false;
                }
            } else if (profile.firstName == null) {
                AppMethodBeat.o(17250);
                return true;
            } else {
                AppMethodBeat.o(17250);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(17251);
        int hashCode = this.id.hashCode() + JsApiGetABTestConfig.CTRL_INDEX;
        if (this.firstName != null) {
            hashCode = (hashCode * 31) + this.firstName.hashCode();
        }
        if (this.middleName != null) {
            hashCode = (hashCode * 31) + this.middleName.hashCode();
        }
        if (this.lastName != null) {
            hashCode = (hashCode * 31) + this.lastName.hashCode();
        }
        if (this.name != null) {
            hashCode = (hashCode * 31) + this.name.hashCode();
        }
        if (this.linkUri != null) {
            hashCode = (hashCode * 31) + this.linkUri.hashCode();
        }
        AppMethodBeat.o(17251);
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(17252);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put(MIDDLE_NAME_KEY, this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            if (this.linkUri != null) {
                jSONObject.put(LINK_URI_KEY, this.linkUri.toString());
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        AppMethodBeat.o(17252);
        return jSONObject;
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        AppMethodBeat.i(17253);
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, null);
        this.name = jSONObject.optString("name", null);
        String optString = jSONObject.optString(LINK_URI_KEY, null);
        this.linkUri = optString != null ? Uri.parse(optString) : uri;
        AppMethodBeat.o(17253);
    }

    private Profile(Parcel parcel) {
        AppMethodBeat.i(17254);
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        this.linkUri = readString == null ? null : Uri.parse(readString);
        AppMethodBeat.o(17254);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(17255);
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        parcel.writeString(this.linkUri == null ? null : this.linkUri.toString());
        AppMethodBeat.o(17255);
    }
}
