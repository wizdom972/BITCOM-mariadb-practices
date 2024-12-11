-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 단 조회결과는 급여의 내림차순으로 정렬되어 나타나야 합니다. 

-- 문제1.
-- 현재 전체 사원의 평균 급여보다 많은 급여를 받는 사원은 몇 명이나 있습니까?
select count(*) as employee_count
from salaries s
where s.to_date = '9999-01-01'
  and s.salary > (select avg(salary) from salaries where to_date = '9999-01-01');

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 급여을 조회하세요. 단 조회결과는 급여의 내림차순으로 정렬합니다.
select de.emp_no, e.first_name, e.last_name, d.dept_name, s.salary
from dept_emp de
join employees e on de.emp_no = e.emp_no
join departments d on de.dept_no = d.dept_no
join salaries s on de.emp_no = s.emp_no
where de.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
  and s.salary = (
    select max(salary)
    from salaries
    where emp_no in (
      select emp_no
      from dept_emp
      where dept_no = de.dept_no
        and to_date = '9999-01-01'
    )
  )
order by s.salary desc;

-- 문제3.
-- 현재, 사원 자신들의 부서의 평균급여보다 급여가 많은 사원들의 사번, 이름 그리고 급여를 조회하세요 
select e.emp_no, e.first_name, e.last_name, s.salary
from employees e
join salaries s on e.emp_no = s.emp_no
join dept_emp de on e.emp_no = de.emp_no
where s.to_date = '9999-01-01'
  and de.to_date = '9999-01-01'
  and s.salary > (
    select avg(salary)
    from salaries s2
    join dept_emp de2 on s2.emp_no = de2.emp_no
    where de2.dept_no = de.dept_no
      and s2.to_date = '9999-01-01'
      and de2.to_date = '9999-01-01'
  );

-- 문제4.
-- 현재, 사원들의 사번, 이름, 그리고 매니저 이름과 부서 이름을 출력해 보세요.
select e.emp_no, e.first_name, e.last_name, m.first_name as manager_first_name, m.last_name as manager_last_name, d.dept_name
from employees e
join dept_emp de on e.emp_no = de.emp_no
join dept_manager dm on de.dept_no = dm.dept_no
join employees m on dm.emp_no = m.emp_no
join departments d on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
  and dm.to_date = '9999-01-01';

-- 문제5.
-- 현재, 평균급여가 가장 높은 부서의 사원들의 사번, 이름, 직책 그리고 급여를 조회하고 급여 순으로 출력하세요.
select e.emp_no, e.first_name, e.last_name, t.title, s.salary
from employees e
join titles t on e.emp_no = t.emp_no
join salaries s on e.emp_no = s.emp_no
join dept_emp de on e.emp_no = de.emp_no
where t.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
  and de.to_date = '9999-01-01'
  and de.dept_no = (
    select dept_no
    from dept_emp de2
    join salaries s2 on de2.emp_no = s2.emp_no
    where de2.to_date = '9999-01-01'
      and s2.to_date = '9999-01-01'
    group by de2.dept_no
    order by avg(s2.salary) desc
    limit 1
  )
order by s.salary desc;

-- 문제6.
-- 현재, 평균 급여가 가장 높은 부서의 이름 그리고 평균급여를 출력하세요.
select d.dept_name, avg(s.salary) as avg_salary
from departments d
join dept_emp de on d.dept_no = de.dept_no
join salaries s on de.emp_no = s.emp_no
where de.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
group by d.dept_name
order by avg_salary desc
limit 1;

-- 문제7.
-- 현재, 평균 급여가 가장 높은 직책의 타이틀 그리고 평균급여를 출력하세요.
select t.title, avg(s.salary) as avg_salary
from titles t
join salaries s on t.emp_no = s.emp_no
where t.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
group by t.title
order by avg_salary desc
limit 1;