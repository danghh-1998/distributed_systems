# Chương 1: Tổng quan các hệ phân tán

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Nêu hai ví dụ về hệ phân tán

### BitTorrent

- Là một giao thức chia sẻ tài nguyên trên mạng ngang hàng(peer to peer), tức là nhiều người cùng kết nối trực tiếp với nhau để chia sẻ file. Chuyên được dùng để chia sẻm trao đổi file có dung lượng lớn.
- Tracker trong torrent sẽ gửi IP của máy mình để gửi cho những leech khác, đồng thời tracker cũng sẽ cung cấp IP của máy khác cho chúng ta để chúng ta có thể tải file về. Các máy tính  có kiến trúc khác nhau, chia sẻ tài nguyên với nhau thông qua mạng peer to peer nên đây có thể xem là một hệ phân tán.

### Distributed database

- Là một tập hợp, mà về mặt logic tập hợp này cùng thuộc một hệ thống, nhưng về mặt vật lý, dữ liệu đó được phân tán trên các máy tính khác nhau trong hệ thống.

## Câu 2

> Tại sao tính chia sẻ tài nguyên trong hệ phân tán làm giảm chi phí,
> tăng tính sẵn sàng, khả năng làm việc nhóm nhưng lại tăng rủi ro bảo mật?

- Làm giảm chi phí: Ví dụ các trang web cung cấp dịch vụ tra cứu điểm chuẩn các trường đại học thường sẽ có nhiều người sử dụng vào thời gian tháng 7, tháng 8, các tháng khác hiếm người sử dụng. Thay vì sử dụng một server để chịu tải đủ cho nhu cầu trong thời gian cao điểm sẽ gây lãng phí tài nguyên không cần thiết, người ta có thể chỉ sử dụng một server vừa phải, trong thời gian cao điểm, ta chỉ cần tăng thêm số server và dùng load balancing để phân tải sẽ giảm chi phí đi rất nhiều.
- Tăng tính sẵn sàng: Đối với các dịch vụ xuyên quốc gia như của Google, Facebook..., khi người dùng gửi yêu cầu lên hệ thống. Nếu sử dụng một máy chủ nằm cố định ở Mỹ thì các quốc gia như Việt Nam, Nhật Bản.. sẽ phải chịu độ trễ lan truyền lớn. Thay vào đó, các công ty tạo các cụm máy chủ nằm dải rác trên thế giới, đồng bộ với nhau nhằm giảm độ trễ do khoảng cách địa lý.
- Tăng khả năng làm việc nhóm: Một ví dụ điển hình là hệ phân tán mã nguồn Git, khi làm việc với Git, mã nguồn sẽ được phân tán tới máy tính của các thành viên trong nhóm. Thành viên trong nhóm có thể chủ động truy cập, đồng bộ mã nguồn thông qua các lệnh `git pull` và `git push`
- Tăng rủi ro bảo mật: Khi các máy tính kết nối với nhau, thông tin có thể lấy cắp trong quá trrình trao đổi

## Câu 3

> Liên quan đến tính trong suốt, giải thích tại sao nhà quản trị hệ thống phải xem 
> xét việc cân bằng giữa hiệu năng và độ trong suốt? Đưa ra ví dụ cụ thể để giải thích

- Hệ thống càng trong suốt thì càng phải áp dụng nhiều các kỹ thuật phức tạp, vô hình chung làm giảm hiệu năng của hệ thống
- Ví dụ: Một hệ thống được xây dựng dựa trên kiến trúc monolithic khi một phần của hệ thống bị lỗi sẽ dẫn đến cả hệ thống hoạt động sai lệch hoặc sụp đổ hoàn toàn. Ý tưởng là ta có thể chia nhỏ ứng dụng thành các service nhỏ hơn giao tiếp với nhau (microservice) có khả năng nhân bản khi một instance bị lỗi và đảm bảo hệ thống không sụp đổ. Điều này thực hiện trong suốt với người dùng, tuy nhiên mô hình này cũng có nhược điểm, chia quá nhiều dẫn đến dữ liệu bị phân tán quá mức, khi có yêu cầu từ người dùng thì phải thông qua các service nhỏ, các dịch vụ này kết nối với nhau thông qua mạng, khi kết nối kém sẽ không thể đảm bảo hiệu năng như kiến trúc monolithic.

## Câu 4

> Tại sao giao diện (Interface) lại quan trọng đối với Tính mở của Hệ Phân Tán?

- Hệ phân tán bao gồm nhiều thành phần tương tác với nhau. Một hệ thống mở là hệ thống cho phép các thành phần được tạo bởi các nhà sản xuất khác nhau có thể thay thế lẫn nhau, đồng thời có thể thêm thành phần mới vào hệ thống. Để có thể thay thế hoặc thêm mới các thành phần của các nhà sản xuất khác nhau cần có một mô hình tương tác giữa các thành phần được quy định bởi cú pháp và ngữ nghĩa của các dịch vụ được cung cấp gọi là giao diện.

## Câu 5

> So sánh 2 kiểu HĐH DOS và NOS

|      | Miltiprocessor (DOS) | Multicomputer (DOS) | NOS | Middleware |
| :--: | :--: | :--: | :--: | :--: |
| Mức độ trong suốt | Rất cao | Cao |Thấp| Cao |
| Cùng một hệ điều hành | Có | Có | Không | Không |
| Trao đổi thông tin | Bộ nhớ | Thông điệp | Tệp | Tùy |
| Số lượng hệ điều hành | 1 | N | N | N |
| Quản lý tài nguyên | Toàn cục tập trung | Toàn cục phân tán | Mỗi nút | Mỗi nút |
| Tính co giãn | Không | Có thể | Có | Tùy thuộc |
| Tính mở | Đóng | Đóng | Mở | Mở |

