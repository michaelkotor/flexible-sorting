import http from "../http-common";

class UploadFilesService {
  upload(file, type, onUploadProgress) {
    let formData = new FormData();

    formData.append("file", file);
    formData.append("sortingAlgorithm", type);

    return http.post("http://localhost:8080/file/upload", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  getFiles() {
    return http.get("http://localhost:8080/sorting/types");
  }
}

export default new UploadFilesService();
