package ru.ucscards.test_task.model;

public class Response {
    private Data data;
    private String response;
    private String request;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Response response1 = (Response) o;

        if (data != null ? !data.equals(response1.data) : response1.data != null) {
            return false;
        }
        if (response != null ? !response.equals(response1.response) : response1.response != null) {
            return false;
        }
        return request != null ? request.equals(response1.request) : response1.request == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (request != null ? request.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", response='" + response + '\'' +
                ", request='" + request + '\'' +
                '}';
    }
}
