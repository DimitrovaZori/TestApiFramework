package in.reqres.model.response.singleuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private UserDetail data;
    private Support support;

    public UserDetail getData() {
        return data;
    }

    public void setData(UserDetail data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
