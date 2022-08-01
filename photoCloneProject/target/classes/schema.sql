create table if not exists photo (
  id bigint identity PRIMARY KEY,
  file_name varchar(240),
  content_type varchar(240),
  data binary
)