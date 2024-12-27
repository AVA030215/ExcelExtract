// DOMContentLoaded 이벤트로 HTML이 로드된 후 실행
document.addEventListener("DOMContentLoaded", () => {
    const downloadButton = document.getElementById("download-btn");

    // 예제 데이터 배열
    const data = [
        { Name: "Ava Lee", Email: "chaechae0215@gmail.com", Department: "HR" },
        { Name: "Chaeeun Lee", Email: "bluemoon3_00@naver.com", Department: "IT" },
        { Name: "John Doe", Email: "john.doe@example.com", Department: "HR" },
        { Name: "Jane Smith", Email: "jane.smith@example.com", Department: "IT" },
        { Name: "Selena Lee", Email: "selena.lee@example.com", Department: "Finance" }
    ];

    // 테이블에 데이터를 동적으로 추가하는 함수
    const tableBody = document.querySelector("#data-table tbody");
    data.forEach(row => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${row.Name}</td>
            <td>${row.Email}</td>
            <td>${row.Department}</td>
        `;
        tableBody.appendChild(tr);
    });

    // "Download Excel" 버튼 클릭 이벤트 리스너
    downloadButton.addEventListener("click", () => {
        // Excel 파일 다운로드를 위한 백엔드 API 호출
        window.location.href = "/excel";
    });
});