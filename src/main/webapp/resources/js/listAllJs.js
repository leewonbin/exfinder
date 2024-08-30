	$(document).ready(
			function() {
				// 등록 성공 알림창
				var result = '${msg}';
				if (result == 'success') {
					alert("처리가 완료되었습니다.");
				}

				// 카테고리별 조회? 버튼 
				$('.cButton').on(
						"click",
						function() {
							var category = $(this).data('category');
							var url = "listAll?bCategory="
									+ encodeURIComponent(category);
							window.location.href = url;
						});

				// 검색하기 버튼
				$('#searchBtn')
						.on(
								"click",
								function(event) {
									var searchType = $(
											"select[name='searchType']").val();
									var keyword = $('#keywordInput').val();
									var url = "listAll?bCategory="
											+ encodeURIComponent(searchType)
											+ "&keyword="
											+ encodeURIComponent(keyword);
									window.location.href = url;
								});

				// 글쓰기 버튼
				$('.writeBtn').on("click", function(event) {
					location.href = "/ex/board/create";
				});
			});
