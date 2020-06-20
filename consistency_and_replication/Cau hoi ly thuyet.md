# Chương 7: Sao lưu và thống nhất dữ liệu

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Tại sao phải thực hiện sao lưu dữ liệu?

Ta phải thực hiện sao lưu dữ liệu để:

- Tăng hiệu năng, tăng số lượng và phạm vi địa lý của hệ thống.
- Tăng độ tin cậy, tính sẵn sàng của hệ thống. Khi hệ thống gặp lỗi ta có thể dùng các bản sao lưu để khôi phục lại hệ thống.

## Câu 2

> Xét một kho dữ liệu phân tán với 5 tiến trình độc lập P1, P2, P3, P4, và P5. Mỗi tiến trình chỉ tác động lên được bản sao cục bộ riêng của mình. Các bản sao cục bộ kết nối thành kho dữ liệu phân tán. Xét các tiến trình chỉ tương tác (ghi, đọc) lên thành phần dữ liệu x ở bản sao cục bộ riêng của mình. Hoạt động của mô hình ở các thời điểm t tương ứng, các thao tác được thực hiện như sau:
> t1: P1 ghi giá trị a
> t2: P3 đọc giá trị a
> t3: P2 ghi giá trị b và P3 ghi giá trị c
> t4: P5 đọc được giá trị b
> t5: P4 và P5 đều đọc được giá trị a
> t6: P4 đọc được giá trị b
> t7: P4 và P5 đọc được giá trị c
> (biết rằng ti < ti+1 với i=(0..6)
> Câu hỏi:
> a. Mô hình trên có thoả mãn thống nhất nhân quả không? Giải thích.
> b. Mô hình trên có thoả mãn thống nhất tuần tự không? Giải thích.

|      |  t1   |  t2   |  t3   |  t4   |  t5   |  t6   |  t7   |
| :--: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  P1  | W(x)a |       |       |       |       |       |       |
|  P2  |       |       | W(x)b |       |       |       |       |
|  P3  |       | R(x)a | W(x)c |       |       |       |       |
|  P4  |       |       |       |       | R(x)a | R(x)b | R(x)c |
|  P5  |       |       |       | R(x)b | R(x)a |       | R(x)c |

a. Mô hình thỏa mãn tính nhân quả vì các các thao tác ghi ở P4, P5 thỏa mãn tính chất đọc a trước đọc c sau dựa vào tính nhân quả ở tiến trình P3(đọc a trước rồi mới ghi c).

b. Mô hình trên không thỏa mãn tính chất tuần tự vì tiến trình P4 và P5 có thứ tự đọc khác nhau.

## Câu 3

> Conit là gì? Nếu đặt kích thước Conit quá lớn thì sẽ gây ra vấn đề gì? Tương tự với kích thước Conit quá nhỏ?

Conit là một đơn vị thống nhất.

Nếu kích thước Conit quá lớn thì các bản sao sẽ sớm bị rơi vào trạng thái không thống nhất.

Nếu kích thước Conit quá nhỏ thì số lượng Conit sẽ nhiều, dẫn đến quản lý phức tạp.

## Câu 4

> Tại sao thống nhất nhân quả có tính thống nhất yếu hơn thống nhất tuần tự? Cho ví dụ để làm rõ điều này.

Tính chất nhân quả có tính thống nhất yếu hơn thống nhất tuần tự vì mô hình phân biệt có quan hệ nhân quả và các sự kiện không có quan hệ nhân quả.

Ví dụ sự kiện b được gây ra hoặc bị tác động bởi một sự kiện a xảy ra sớm hơn thì tính nhân quả đòi hỏi mọi thực thể khác phải "nhìn" thấy a trước rồi mới thấy b sau.

## Câu 5

> Vấn đề của mô hình Eventual Consistency là gì? Từ đó đưa ra định nghĩa mô hình thống nhất hướng client.

Vấn đề của mô hình Eventual Consistency là khi một dữ liệu có nhiều bản sao thì yêu cầu đưa ra là sau các thao tác cập nhật thì tất cả các bản sao cuối cùng là phải bằng nhau. Yêu cầu này sẽ được thực hiện tốt nếu mỗi client luôn chịu khó cập nhật cho các bản sao.  Vì vậy vấn đề của Eventual Consistency là nếu các client là di động thì việc thực hiện yêu cầu trên gặp khó khăn hơn. Phải luôn đảm bảo rằng ngay cả khi client thay đổi về vị trí vật lý thì việc sử dụng các bản sao cũng phải chính xác. Tức là các bản sao luôn luôn là nhất quán.

Định nghĩa mô hình thống nhất hướng client là phải cung ứng đảm bảo thống nhất  cho các truy cập của một client đơn vào kho dữ liệu.

## Câu 6

> Một ngân hàng quyết định sử dụng dịch vụ CDN (Content Delivery Network) của một công ty mới khởi nghiệp cung cấp.
> a. Với bước đặt máy chủ, công ty chọn thuật toán chọn đặt các máy chủ bản sao (replica) dựa trên khoảng cách với các chi nhánh ngân hàng. Hãy đề xuất thuật toán chọn đặt k replica với N vị trí có thể đặt máy chủ. Biết rằng đây là thuật toán dựa trên khoảng cách và công ty biết trước các vị trí các chi nhánh ngân hàng.
> b. Với thuật toán để quản lý nội dung dữ liệu ở các replica, công ty quyết định chọn thuật toán dựa trên bản sao kích hoạt bởi server (server-initiated replicas). Hãy mô tả cơ chế đó với việc xem xét một đơn vị dữ liệu X là thông tin tài khoản một người dùng cùng với 2 ngưỡng là del(X) và rep(X).
> c. Liên quan đến giao thức đảm bảo thống nhất, công ty quyết định chọn giao thức ghi trên các bản sao (replicated write), tuy nhiên công ty băn khoăn giữa giao thức sao lưu tích cực và giao thức sao lưu dựatrên túc số. Bạn hãy giúp công ty lựa chọn giao thức phù hợp bằng việc so sánh 2 giao thức trên với việc chỉ ra ưu nhược điểm của chúng.

a. Vì thuật toán dựa trên khoảng cách và công ty biết trước vị trí các chi nhánh ngân hàng nên ta có thể lựa chọn giải pháp dựa vào khoảng cách giữa client và các bản sao và xác định từng server.

b. Khi sử dụng thuật toán dựa trên bản sao kích hoạt bởi server, nếu server đang hoạt động mà số lượng các yêu cầu tăng, sẽ kích hoạt các bản sao ở các vị trí khác tùy theo yêu cầu.

c. Đối với giao thức sao lưu tích cực, một tiến trình chịu trách nhiệm phổ biến thao tác cập nhật đến tất cả các bản sao và cần có một cơ chế trật tự toàn cục. Đối với giao thức sao lưu dựa trên túc số, ta sẽ sử dụng sao lưu theo vote-giải thuật quorum, để có thống nhất mạnh thì cần cập nhật tất cả các bản sao.

## Câu 7

> Liên quan đến các mô hình thống nhất hướng dữ liệu và các mô hình thống nhất hướng người dùng:
> a. Giải thích vắn tắt ý tưởng của 2 loại mô hình thống nhất hướng dữ liệu trên.
> b. Một công ty startup mới mở chuyên triển khai thương mại hóa dịch vụ CDN (Content Delivery Network) cho 2 loại hình dịch vụ là thư điện tử và WWW. Để đảm bảo thống nhất dữ liệu cho 2 loại dịch vụ đó thì tầng middleware sẽ áp dụng mô hình thống nhất dữ liệu nào (ở câu a) cho mỗi loại dịch vụ trên? Giải thích.
> c. Công ty đó triển khai 3000 server bản sao vật lý và chọn hình thức sao lưu dữ liệu dựa trên túc số (quorum) với Nw = 1600 và Nr = 1100. Vậy hệ thống đó sẽ tránh được xung đột đọc-ghi và xung đột ghi-ghi hay không? Giải thích.

Mô hình nhất quán hướng dữ liệu là loại mô hình nhất quán được sử dụng rộng rãi nhất. Trong mô hình này, bất kỳ người sử dụng nào truy cập vào kho dữ liệu cũng sẽ nhìn thấy các thao tác được sắp xếp theo mô hình. Trái ngược với các mô hình lấy Client làm trung tâm, nơi Client được yêu cầu một mô hình nhất quản cụ thể và các Client khác nhau sẽ nhìn thấy các thao tác theo những trật tự khác nhau.