import * as React from "react";
import { styled, alpha } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import InputBase from "@mui/material/InputBase";
import MenuIcon from "@mui/icons-material/Menu";
import SearchIcon from "@mui/icons-material/Search";
import { Button, FormControl, InputAdornment, OutlinedInput } from "@mui/material";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { useState } from "react";
import { useUserStore } from "src/stores";

// const Search = styled("div")(({ theme }) => ({
//   position: "relative",
//   borderRadius: theme.shape.borderRadius,
//   backgroundColor: alpha(theme.palette.common.white, 0.15),
//   "&:hover": {
//     backgroundColor: alpha(theme.palette.common.white, 0.25),
//   },
//   marginLeft: 0,
//   width: "100%",
//   [theme.breakpoints.up("sm")]: {
//     marginLeft: theme.spacing(1),
//     width: "auto",
//   },
// }));

// const SearchIconWrapper = styled("div")(({ theme }) => ({
//   padding: theme.spacing(0, 2),
//   height: "100%",
//   position: "absolute",
//   pointerEvents: "none",
//   display: "flex",
//   alignItems: "center",
//   justifyContent: "center",
// }));

// const StyledInputBase = styled(InputBase)(({ theme }) => ({
//   color: "inherit",
//   "& .MuiInputBase-input": {
//     padding: theme.spacing(1, 1, 1, 0),
//     // vertical padding + font size from searchIcon
//     paddingLeft: `calc(1em + ${theme.spacing(4)})`,
//     transition: theme.transitions.create("width"),
//     width: "100%",
//     [theme.breakpoints.up("sm")]: {
//       width: "12ch",
//       "&:focus": {
//         width: "20ch",
//       },
//     },
//   },
// }));

export default function NavigationBar() {

  const [content, setContent] = useState<string>('');

  const { user } = useUserStore();

  const navigator = useNavigate();
  const path = useLocation();
  
  const onSearchHandler = () => {
    if(!content.trim){
      alert('검색어를 입력하세요.');
      return;
    }

    navigator(`/board/search/${content}`);
  }

return (
    <Box sx={{ flexGrow: 1, pr: "120px", pl: "120px" }}>
    <AppBar variant="outlined" position="static" sx={{p:'0px 120px', backgroundColor:"#ffffff"}}>
        <Toolbar>
            <Typography
                variant="h6"
                noWrap
                component="div"
                sx={{ flexGrow: 1, display: { xs: "none", sm: "block" , color:'#000000'} }}
                onClick={() => navigator('/')}
            >
                Hoons Board
            </Typography>

        <Box sx={{display:'flex'}}>
          <FormControl variant="outlined" sx={{mr:'10px'}}>
            <OutlinedInput
              size="small"
              type='text'
              placeholder="검색어를 입력해주세요."
              endAdornment={
                <InputAdornment position="end">
                  <IconButton edge='end' onClick={() => onSearchHandler()}>
                    <SearchIcon/>
                  </IconButton>
                </InputAdornment>
              }
              onChange={(event) => setContent(event.target.value)}
            />
          </FormControl>
          {path.pathname !== '/auth' && (user ? (
            <Button variant="outlined" sx={{borderColor: '#000000', color: '#000000'}} onClick={() => navigator('/myPage')}>마이페이지</Button>
          ) : (
            <Button variant="contained" sx={{backgroundColor:"#000000"}} color="secondary" onClick={() => navigator('/auth')}>
              로그인
            </Button>
          ))}
          
          </Box>

        </Toolbar>
    </AppBar>
    </Box>
);
}
