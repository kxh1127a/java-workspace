# 프로시저
###### 출근 도장
```sql
CREATE OR REPLACE FUNCTION record_check_in(emp_id integer, check_time timestamp)
RETURNS boolean
LANGUAGE plpgsql
AS $$
DECLARE
    work_date DATE := CURRENT_DATE;
    status_text VARCHAR(20);
BEGIN
    status_text := CASE WHEN check_time::time > TIME '09:00:00' THEN 'LATE' ELSE 'NORMAL' END;

    INSERT INTO attendance (employee_id, date, check_in_time, attendance_status)
    VALUES (
        emp_id,
        work_date,
        check_time,
        status_text
    );

    RETURN TRUE;
EXCEPTION WHEN OTHERS THEN
    RETURN FALSE;
END;
$$;

```