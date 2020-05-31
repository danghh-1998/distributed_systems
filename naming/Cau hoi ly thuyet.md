# Chương 5: Định danh

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Tại sao không thể lấy địa chỉ của Access Point để sử dụng như địa chỉ của thực thể?

Ta không thể lấy địa chỉ của Access Point để sử dụng như địa chỉ của thực thể vì thông tin có thể di chuyển từ Access point này sang Access point khác.

## Câu 2

> Với việc sử dụng Định Danh, các vấn đề gì cần phải xem xét?

Các vấn đề cần ơhair xem xét trong việc sử dụng định danh:

- Nếu không gian định danh là hữu hạn thì sẽ dẫn đến cạn kiệt định danh.
- Nếu ta tái sử dụng lại định danh thì có thể dẫn đến bị trùng định danh.

## Câu 3

> Xét một thực thể di chuyển từ vị trí A sang vị trí B. Trong quá trình di chuyển thực thể đó có đi qua các nút trung gian nhưng chỉ dừng lại ở đó khoảng thời gian ngắn. Khi đến B, thực thể đó dừng lại. Chúng ta biết rằng việc thay đổi địa chỉ trong một dịch vụ tổ chức vị trí phân cấp (hierarchical location service) là rất mất thời gian để hoàn thành, vì vậy cần tránh làm việc này khi thực thể tạm dừng ở các nút trung gian. Hãy đề xuất một mô hình kết hợp cả dịch vụ tổ chức vị trí phân cấp và cơ chế chuyển tiếp con trỏ (forwarding pointers) để có thể xác định được vị trí của thực thể khi nó ở các nút trung gian.

- Khi thông tin dịch chuyển đến vị trí trung gian giữa A và B, ta để lại con trỏ khi đến B ghi thêm địa chỉ mới đó dẫn đến mô hình phân cấp.
- Khi chuỗi con trỏ trung gin bị xóa đi, địa chỉ ở A cũng bị xóa đi.

## Câu 4

> Trình bày một số phương pháp ARP Spoofing để thấy được điểm yếu của phương pháp định danh sử dụng cơ chế quảng bá.

- Tấn công ARP Spoofing giúp hacker có thể lấy thông tin trích rút từ gói tin, bất kỳ lưu lượng truy cập gửi cho địa chỉ ip của một máy chủ sẽ bị chuyển sang cho kẻ tấn công. Một số phương pháp ví dụ như nghe trộm, tấn công từ chối dịch vụ, đặt lại mật khẩu, … Vì vậy điểm yếu của phương pháp định danh dựa vào cơ chế quảng bá là hacker có thể giả mạo được địa chỉ MAC để kết hợp với địa chỉ IP máy chủ trích rút toàn bộ thông tin gói tin chuyển đi.

## Câu 5

> Vấn đề còn tồn tại đối với cơ chế chuyển tiếp con trỏ (Forwarding Pointer) là gì?

Vấn đề của Forwarding Pointer là tạo ra chuỗi dài vô hạn, có khả năng sẽ không thể tham chiếu đến nó được. Một vấn đề khác nữa là việc lưu trữ các tham chiếu, khi nào ta có thể loại bỏ được các tham chiếu.

## Câu 6

> Nhược điểm của giải pháp Home-based là gì? Giải pháp nào để giải quyết nhược điểm đó?

Nhược điểm của giải pháp Home-based là nhược điểm của phương pháp này là có thể gây ra trễ mạng, và nếu như thực thể quyết định đổi vị trí gốc thì có thể dẫn đến việc mất dấu vĩnh viễn.

## Câu 7

> Khi áp dụng giải pháp sử dụng hàm băm phân tán vào hệ thống Chord thì nó đã tối ưu cơ chế định danh như thế nào?

- Chord sử dụng một hệ thống không gian định danh m-bit để gán lựa chọn ngẫu nhiên cho nốt cũng như các khóa cho các thực thể cụ thể. Một thực thể với khóa k thuộc quyền hạn của các node được gọi là nốt kế nhiệm của k là succ(k). Phải sử dụng bảng băm để xác định địa chỉ succ(k) của tên k.

## Câu 8

> Trong giải pháp phân cấp, sử dụng cơ chế bộ đệm có tác dụng cải thiện hiệu năng như thế nào? Cho ví dụ.

- Với giải pháp phân cấp, mạng được chia ra thành các domain không chồng lên nhau, chúng có thể được nhóm lại để tạo nên các domain mức cao hơn. Sẽ có một domain mức đỉnh cho tòan bộ mảng , mỗi domain tại mỗi mức có một nút thư mục liên kết với mình. Một số VD như áp dụng giải pháp phân cấp cho thực thể có 2 địa chỉ, cho việc tìm kiếm và cập nhật.

## Câu 9

> So sánh liên kết vật lý và liên kết biểu tượng trong hệ thống quản lý tệp của UNIX.

- Sử dụng liên kết vật lý tốn nhiều không gian hơn sử dụng liên kết biểu tượng trong hệ thống quản lý tệp UNIX. Liên kết biểu tượng bản chất là tham chiếu dùng các liên kết tham chiếu đến file thực trong hệ thống quản lý tệp của UNIX.

## Câu 10

> Khi chúng ta thêm 1 node mới vào hệ thống Chord, chúng ta có cần phải cập nhật toàn bộ các bảng finger?

- Không cần cập nhật lại toàn bộ các bảng finger, chỉ cần cập nhật lại các nút sau và nut trước vì trong hệ thống Chord, mỗi nút sẽ quản lý khóa của nút trước đó.

## Câu 11

> Phân giải tên đệ qui có ưu điểm gì so với phân giải tên không đệ qui?

Ưu điểm của phân giải đẹ quy so với phân giải không dệ quy

- Phân giải đệ quy xử lý nhiều ở server, phân giải không đệ quy xử lý nhiều ở client ở xa, phân giải đệ quy phải gửi đi gửi lại với độ trễ cao.
- Phân giải tên có đệ quy các name server tổ chức lưu trữ bộ nhớ đệm, server lưu trữ kết quả, có thể trả lời luôn và nhanh cho các client.

## 