create table if not exists photo(
id bigint identity primary key,
file_name varchar (255),
content_type varcha (255),
data binary
)