# Chương 4: Trao đổi thông tin

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Trong các giao thức phân tầng, mỗi tầng sẽ có một header riêng. Vậy có nên triển khai một hệ thống mà tất cả các header của các tầng đưa chung vào một phần (gọi là header chung), gắn vào đầu mỗi thông điệp để có thể xử lý chung? Giải thích

- Không nên triển khai một hệ thống mà tất cả các header của các tầng đưa chung vào một phần vì nếu làm vậy các tầng không đọc lập với nhau, không đảm bảo tính trong suốt của các tầng với nhau, mỗi tầng chỉ cần 1 hoặc một số header, gộp chung sẽ khiến dư thừa header không cần thiết khi truyền qua các tầng.

## Câu 2

> Xét 1 thủ tục `incr` với 2 tham số nguyên. Thủ tục làm nhiệm vụ là cộng 2 tham số đó với nhau. Bây giờ xét trường hợp chúng ta gọi thủ tục đó với cùng một biến 2 lần, ví dụ incr(i, j). Nếu biến i được khởi tạo giá trị 0, vậy giá trị của i sẽ là bao nhiêu sau khi gọi thủ tục này trong 2 trường hợp sau: 
>
> - Lời gọi tham chiếu
> - Phương pháp sao chép-phục hồi được sử dụng

- Lời gọi tham chiếu: Nếu tăng `i` một đơn vị thì `i` sẽ được tăng 2 lần => `i = 2`

- Phương pháp sao chép-phục hồi được sử dụng: Sao lưu không làm tăng giá trị của `i` => `i = 1`

## Câu 3

> Một kết nối socket cần 4 thông tin nào? Tại sao phải cần đủ 4 thông tin đó?

- Trong một kết nối socket giữa 2 ứng dụng, khi cần trao đổi dữ liệu cho nhau thì 2 ứng dụng cần phải biết thông tin tối thiểu là IP và sô hiểu cổng của ứng dụng kia.

  ## Câu 4

> Tại sao giao thức yêu cầu-trả lời (request-reply) lại được coi là đồng bộ và tin cậy?

- Bởi vì giao thức request-reply yêu cầu phải trả lời, các ứng dụng trên các máy chủ được nối mạng có thể tạo các kết nối với nhau, nếu không nhận được reply thì gói tin sẽ được gửi lại nên hạn chế mất mát gói tin. Các gói tin được gửi theo đúng thứ tự nên đây là giao thức đồng bộ.

## Câu 5

> Hai vấn đề chính đối với giao thức RPC là gì? 

- Các hệ thống RPC gặp khó khăn khi các hệ thống không đồng nhất với nhau, không gian nhớ khác nhau hoặc cách biếu diễn dữ liệu khác nhau.
- Dễ lỗi nếu một trong hai máy hỏng.

## Câu 6

> Vấn đề đối với truyền tham biến trong RPC là gì? Còn đồi với truyền tham chiếu? Giải pháp đưa ra là gì?

- Đối với truyền tham biến, sẽ gặp vấn đề khi biểu diễn dữ liệu khác nhau, các dữ liệu không cùng một kiểu, các kiểu dữ liệu khác nhau được biển diễn khác nhau. Giải pháp là đồng nhất hệ thống đầu cuối.
- Đối với truyền tham chiếu, sẽ gặp vấn đề đối với bộ phân tán, trong việc copy dữ liệu(copy - restore) hoặc chuyển tham chiếu và code vào để truy cập tham chiếu. Giải pháp không sử dụng các tham chiếu, đối với vấn đề copy-restore có thể cải thiện bằng cách chỉ copy một lần.

## Câu 7

> So sánh RMI và RPC. Nhược điểm của RMI so với RPC là gì?

- Giống nhau
  - Hỗ trợ lập trình giữa các giao diện.
  - Dựa trên giao thức request-reply.
  - Đảm bảo tính trong suốt.
- Khác nhau
  - RMI hỗ trợ lập trình OOP
  - Sử dụng định danh duy nhất, truyền tham chiếu đối tương.
- Nhược điểm của RMI so với RPC
  - RMI chỉ hỗ trợ Java

## Câu 8

> Hàm `listen` được sử dụng bởi TCP server có tham số là backlog. Giải thích ý nghĩa tham số đó

- Tham số backlog chỉ định số lượng kết nối tối đa mà hạt nhân kernel nên xếp cho socket.

## Câu 9

> Trong trao đổi thông tin hướng dòng, những cơ chế thực thi QoS được thực hiện ở tầng nào? Giải thích. Trình bày một số cơ chế thực thi QoS để chứng minh điều đó.

- Trong trao đổi thông tin hướng dòng, các cơ chế thực thi QoS được thực hiện ở tầng IP vì nó đề cập đến tất cả các khía cạnh liên quan đến hiệu quả hoạt động của mạng,  gồm các kỹ thuật xử lý lưu lượng trong mạng. Một số cơ chế thực thi QoS như đo độ delay, đo bitrate, round-trip delay, …

  Ví dụ đo Jitter chính là đo độ biến động trễ (sự khác nhau về thời gian đến của các gói tin thuộc cùng một luồng lưu lượng). Đo độ delay cho biết khoảng thời gian gói IP được chuyển từ đầu gửi đến đầu nhận.